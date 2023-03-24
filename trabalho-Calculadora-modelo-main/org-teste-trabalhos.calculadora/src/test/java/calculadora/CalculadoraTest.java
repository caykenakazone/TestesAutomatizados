package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	private Calculadora calc;

	@BeforeEach
	public void before(){
		calc = new Calculadora();
	}

	@Test
	public void testarConstrutorSemParametroIniciaMemoriaComZero() {
		 calc = new Calculadora();
		//definir cenário
		int memoriaEsperada = 0;

		//executar
		int memoriaObtida = calc.getMemoria();
		
		//comparar

		assertEquals(memoriaEsperada, memoriaObtida);
	}
	@Test
	public void testarConstrutorComParametro0(){
		calc = new Calculadora(0);
		int memoriaEsperada = 0;

		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada, memoriaObtida);
	}
	@Test
	public void testarConstrutorComParametroNegativo(){
		calc = new Calculadora(-10);
		int memoriaEsperada = -10;

		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada, memoriaObtida);
	}
	@Test
	public void testarConstrutorComParametroPositivo(){
		calc = new Calculadora(10);
		int memoriaEsperada = 10;

		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada, memoriaObtida);
	}
	@Test
	public void testarMetodoSomarNumeroNegatvo(){
		calc.somar(-5);
		int memoriaEsperada = -5;

		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada, memoriaObtida);
	}

	@Test
	public void testarMetodoSubtrairPositivo(){
		calc.subtrair(5);
		int memoriaEsperada = 5;

		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada, memoriaObtida);
	}

	@Test
	public void testarMetodoMultiplicarPositivo(){
		calc.subtrair(3);
		int memoriaEsperada = 0;

		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada, memoriaObtida);
	}

	@Test
	public void testarMetodoMDividirPor0() {
		assertThrows(Exception.class, () -> calc.dividir(0));
	}

	@Test
	public void testarMetodoMDividirPorPositivo() throws Exception {
		calc = new Calculadora(9);
		calc.dividir(3);
		int memoriaEsperada = 3;
		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada,memoriaObtida);
	}

	@Test
	public void testarMetodoExponenciar1(){
		Calculadora calc = new Calculadora();

		assertThrows(Exception.class, ()->calc.exponenciar(1));
	}

	@Test
	public void testarMetodoExponenciarPor10() {
		Calculadora calc = new Calculadora(10);

		assertThrows(Exception.class, ()->calc.exponenciar(11));
	}

	@Test
	public void testarMetodoZerarMemoria(){
		Calculadora calc = new Calculadora(1);
		calc.zerarMemoria();
		int memoriaEsperada = 0;
		int memoriaObtida = calc.getMemoria();
		assertEquals(memoriaEsperada, memoriaObtida);
	}
}
