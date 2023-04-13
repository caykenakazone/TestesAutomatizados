package pessoa.test;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import pessoa.entity.Funcionario;
import pessoa.entity.FuncionarioTercerizado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FuncionarioTercerizadoTest {

    private FuncionarioTercerizado funcionarioTercerizado;
    @BeforeEach
    public void funcTercerizado(){
        funcionarioTercerizado = new FuncionarioTercerizado(200);
    }
    @Test
    public void testarConstrutorEntradaDespesasInvalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            FuncionarioTercerizado funcionario = new FuncionarioTercerizado(-1000);
        });
    }
    @Test
    public void testarConstrutorEntradasValida(){
         FuncionarioTercerizado funTercerizado = new FuncionarioTercerizado(500);
        assertEquals(500,funTercerizado.getDespesasAdicionais());
    }

    @Test
    public void testarModificarDespesasEntradaInvalida(){

        assertThrows(IllegalArgumentException.class, ()->{
            FuncionarioTercerizado funcionarioTercerizado = new FuncionarioTercerizado(1200);
        });
    }

    @Test
    public void testarModificarDespesasEntradaValida(){
        FuncionarioTercerizado funTercerizado = new FuncionarioTercerizado(500);
        assertEquals(500,funTercerizado.getDespesasAdicionais());
    }


}

