package pessoa.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pessoa.entity.Funcionario;
import pessoa.entity.FuncionarioTercerizado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioTercerizadoTest {

    private FuncionarioTercerizado funcionarioTercerizado;
    @BeforeEach
    public void funcTercerizado(){
        funcionarioTercerizado = new FuncionarioTercerizado("Cayke",20,70,200);
    }
    @Test
    public void testarConstrutorEntradaDespesasInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            FuncionarioTercerizado funcionario = new FuncionarioTercerizado("Cayke",20,70,-1200);
        });
    }
    @Test
    public void testarConstrutorEntradasValida(){
         FuncionarioTercerizado funTercerizado = new FuncionarioTercerizado("Cayke",20,70,500);
        assertEquals(500,funTercerizado.getDespesasAdicionais());
    }

    @Test
    public void testarModificarDespesasEntradaInvalida(){

        assertThrows(IllegalArgumentException.class, ()->{
           funcionarioTercerizado.setDespesasAdicionais(1200);
        });
    }

    @Test
    public void testarModificarDespesasEntradaValida(){
        funcionarioTercerizado.setDespesasAdicionais(200);
        assertEquals(200,funcionarioTercerizado.getDespesasAdicionais());
    }


}

