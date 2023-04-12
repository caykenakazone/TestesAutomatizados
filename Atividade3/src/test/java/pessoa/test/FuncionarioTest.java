package pessoa.test;

import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;
import pessoa.entity.Funcionario;

public class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    public void constructor(){
        funcionario = new Funcionario("Carlos",60,120);
    }
    @Test
    public void testarSetNome(){
        funcionario.
    }
}
