package com.iftm.client.repositories;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.iftm.client.entities.Client;

@DataJpaTest
public class ClientRepositoryTest {
    @Autowired
    private ClientRepository repositorio;

    @Test
    @DisplayName("Verifica se a busca por id realmente retornao\n"+"          * cliente correto.")
    public void testarBuscarPorIDRetornaClienteCorreto(){
        long idBuscado = 1;
        String nomeBuscado = "Conceição Evaristo";
        String cpfBuscado = "10619244881";

        Optional<Client> resposta = repositorio.findById(idBuscado);

        Assertions.
    }
}
