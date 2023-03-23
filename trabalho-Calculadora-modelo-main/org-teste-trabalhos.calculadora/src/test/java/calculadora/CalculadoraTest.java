package calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraTest {
	private Calculadora calc;
	
	
	@Test
	public void testarConstrutorSemParametroIniciaMemoriaComZero() {
		calc = new Calculadora();
		//definir cenário
		int memoriaEsperada = 0;

		//executar
		int memoriaObtida = calc.getMemoria();
		
		//comparar
		assertEquals(resultadoEsperado, resultadoObtido);
	}
}
