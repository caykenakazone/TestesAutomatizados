package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    @Test
    public void testarSomaDoisInteirosComSucesso() {
        //Arrange - Definir cenario de teste
        Calculadora calc = new Calculadora();
        int entradaNumeroUm = 10;
        int entradaNumeroDois = 5;
        int saidaEsperada = 15;
        //Act - Executar métodos que estão sendo testados
        int saidaObtida = calc.somar(entradaNumeroUm, entradaNumeroDois);
        //Assign - Validar o resultado obtido
        Assertions.assertEquals(saidaEsperada, saidaObtida);
    }
    @Test
    public void testarMultiplicarDoisInteirosComSucesso() {
        //Arrange - Definir cenario de teste
        Calculadora calc = new Calculadora();
        int entradaNumeroUm = 10;
        int entradaNumeroDois = 5;
        int saidaEsperada = 50;
        //Act - Executar métodos que estão sendo testados
        int saidaObtida = calc.multiplicar(entradaNumeroUm, entradaNumeroDois);
        //Assign - Validar o resultado obtido
        Assertions.assertEquals(saidaEsperada, saidaObtida);
    }
    @Test
    public void testarSubtrairDoisInteirosComSucesso() {
        //Arrange - Definir cenario de teste
        Calculadora calc = new Calculadora();
        int entradaNumeroUm = 10;
        int entradaNumeroDois = 5;
        int saidaEsperada = 5;
        //Act - Executar métodos que estão sendo testados
        int saidaObtida = calc.subtrair(entradaNumeroUm, entradaNumeroDois);
        //Assign - Validar o resultado obtido
        Assertions.assertEquals(saidaEsperada, saidaObtida);
    }@Test
    public void testarDividirDoisInteirosComSucesso() throws Exception {
        //Arrange - Definir cenario de teste
        Calculadora calc = new Calculadora();
        int entradaNumeroUm = 10;
        int entradaNumeroDois = 2;

        //Act + Assign - Executa o metodo que valida a ocorrencia de erro
        Assertions.assertThrows(ArithmeticException.class,()->calc.dividir(entradaNumeroUm, entradaNumeroDois));

    }
}