package com.iftm.client.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iftm.client.dto.ClientDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientRepositoryTestIT {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Verificar se o endpoint get/clients/ retorna todos os clientes existentes")
    public void testarEndPointRetornaTodosOsRegistros() throws Exception {
        int qtdClient = 12;

        ResultActions resultado = mockMvc.perform(get("/clients/")
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 7L).exists())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 4L).exists())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 8L).exists())
                .andExpect(jsonPath("$.numberOfElements").exists())
                .andExpect(jsonPath("$.numberOfElements").value(qtdClient))
                .andExpect(jsonPath("$.first").exists())
                .andExpect(jsonPath("$.first").value(true));
    }

    @Test
    @DisplayName("Verifica se o endpoint clients/id retorna o cliente correto quando o id existe")
    public void verificaSeOEndpointRetornaOClienteCorretoQuandoOIDExiste() throws Exception{
        long idExistente = 4L;

        ResultActions resultado = mockMvc.perform(get("/clients/{id}", idExistente)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(idExistente))
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.name").value("Carolina Maria de Jesus"))
                .andExpect(jsonPath("$.cpf").exists())
                .andExpect(jsonPath("$.cpf").value("10419244771"))
                .andExpect(jsonPath("$.income").exists())
                .andExpect(jsonPath("$.income").value(7500.0))
                .andExpect(jsonPath("$.birthDate").exists())
                .andExpect(jsonPath("$.birthDate").value("1996-12-23T07:00:00Z"))
                .andExpect(jsonPath("$.children").exists())
                .andExpect(jsonPath("$.children").value(0));
    }

    @Test
    @DisplayName("Testa se delete retorna no content quando o id existir")
    public void testaRetornoSucessoDelete() throws Exception {
        long idExistente = 4L;

        ResultActions resultado = mockMvc.perform(delete("/clients/{id}",idExistente)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Testa se delete retorna not found quando o id existir")
    public void testaRetornoErroDelete() throws Exception {
        long idExistente = 942L;

        ResultActions resultado = mockMvc.perform(delete("/clients/{id}",idExistente)
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Testa se update retorna sucesso ao inserir cliente")
    public void testaRetornoSucessoInsert() throws Exception {
        ClientDTO client = new ClientDTO(99L,
                "User",
                "123123123",
                5000.0,
                Instant.parse("1996-12-23T07:00:00Z"),
                3);

        String json = objectMapper.writeValueAsString(client);

        ResultActions result = mockMvc.perform(post("/clients/")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isCreated())
            .andExpect(jsonPath("$.name").exists())
            .andExpect(jsonPath("$.name").value(client.getName()))
            .andExpect(jsonPath("$.cpf").exists())
            .andExpect(jsonPath("$.cpf").value(client.getCpf()))
            .andExpect(jsonPath("$.income").exists())
            .andExpect(jsonPath("$.income").value(client.getIncome()))
            .andExpect(jsonPath("$.birthDate").exists())
            .andExpect(jsonPath("$.birthDate").value(client.getBirthDate().toString()))
            .andExpect(jsonPath("$.children").exists())
            .andExpect(jsonPath("$.children").value(client.getChildren()));
    }

    @Test
    @DisplayName("Testa se update retorna sucesso ao alterar cliente")
    public void testaRetornoSucessoUpdate() throws Exception {
        ClientDTO client = new ClientDTO(3L,
                "User",
                "123123123",
                5000.0,
                Instant.parse("1996-12-23T07:00:00Z"),
                3);

        String json = objectMapper.writeValueAsString(client);

        ResultActions result = mockMvc.perform(put("/clients/")
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.id").value(3L))
                .andExpect(jsonPath("$.name").exists())
                .andExpect(jsonPath("$.name").value(client.getName()))
                .andExpect(jsonPath("$.cpf").exists())
                .andExpect(jsonPath("$.cpf").value(client.getCpf()));
    }

    @Test
    @DisplayName("Testa se update retorna erro ao alterar cliente inexistente")
    public void testaRetornoErroUpdate() throws Exception {
        ClientDTO client = new ClientDTO(99L,
                "User",
                "123123123",
                5000.0,
                Instant.parse("1996-12-23T07:00:00Z"),
                3);

        String json = objectMapper.writeValueAsString(client);

        ResultActions result = mockMvc.perform(put("/clients/{id}", client.getId())
                .content(json)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        result.andExpect(status().isNotFound())
                .andExpect(jsonPath("$.error").value("Resource not found"));
    }

    @Test
    @DisplayName("Verificar se o endpoint get/clients/ retorna registros especificos")
    public void testarEndPointRetornaRegistrosEspecificosFindByIncome() throws Exception {
        ResultActions resultado = mockMvc.perform(get("/clients/incomeGreaterThan/")
                .param("income", String.valueOf(6000.00))
                .accept(MediaType.APPLICATION_JSON));

        resultado.andExpect(status().isOk())
                .andExpect(jsonPath("$.content").exists())
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 4L).exists())
                .andExpect(jsonPath("$.content[?(@.id == '%s')]", 8L).exists())
                .andExpect(jsonPath("$.numberOfElements").exists())
                .andExpect(jsonPath("$.numberOfElements").value(2))
                .andExpect(jsonPath("$.first").exists())
                .andExpect(jsonPath("$.first").value(true));
    }
}