package pessoa.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pessoa.entity.Funcionario;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FuncionarioTest {

    private Funcionario funcionario;

    @BeforeEach
    public void constructor() {
        funcionario = new Funcionario("Carlos", 30, 56);
    }

    @Test
    public void testarConstrutorNomeNulo() {
        Assertions.assertThrows(Exception.class, () -> {
            new Funcionario("", 40, 70);
        });
    }

    @Test
    public void testarConstrutorComEntradasValidas() {
        Funcionario func = new Funcionario("Ryann", 30, 60);
        assertEquals("Ryann", func.getNome());
        assertEquals(30, func.getHorasTrabalhadas());
        assertEquals(60, func.getValorHora());

    }

    @Test
    public void testarConstrutorEntradaHorasInvalida() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Funcionario funcionarioInvalido = new Funcionario("Pedro", 41, 60);
        });
    }

    @Test
    public void testarConstrutorEntradaHorasValida() {
        Funcionario funcionarioValido = new Funcionario("Gerson", 20, 80);
        assertEquals("Gerson", funcionarioValido.getNome());
        assertEquals(20, funcionarioValido.getHorasTrabalhadas());
        assertEquals(80, funcionarioValido.getValorHora());
    }

    @Test
    public void testarConstrutorEntradaHorasTrabalhadasZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Funcionario f = new Funcionario("Rayanne", 0, 60);
        });
    }

    @Test
    public void testarModificarValorPagamentoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            funcionario.modificarValorPagamento(2.0);
        });
    }

    @Test
    public void testarModificarValorPagamentoValido() {
        Funcionario funcionario = new Funcionario("Carlos", 38, 56.0);
        funcionario.setValorHora(60);
        assertEquals(60, funcionario.getValorHora());
    }

    @Test
    public void testarSetHorasTrabalhadasValido() {
        Funcionario funcionarioSetHoras = new Funcionario("Marquinhos", 10, 56);
        funcionarioSetHoras.setHorasTrabalhadas(30);
        Assertions.assertEquals(30, funcionarioSetHoras.getHorasTrabalhadas());
    }

    @Test
    public void testarSetHorasTrabalhadasInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            funcionario.setHorasTrabalhadas(50);
        });
    }

    @Test
    public void testarSetValorHoraValido() {
        Funcionario funcionarioValorHora = new Funcionario("Bruno", 15, 40.00);
        funcionarioValorHora.setValorHora(80.00);
        Assertions.assertEquals(80.00, funcionarioValorHora.getValorHora());
    }

    @Test
    public void testarSetValorHoraAbaixoDoMinimoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            funcionario.setValorHora(30.00);
        });
    }
}
