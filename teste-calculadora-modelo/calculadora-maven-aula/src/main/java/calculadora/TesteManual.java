package calculadora;

public class TesteManual {

	public static void main(String[] args) {
		Calculadora calc = new Calculadora();
	    //cenário de teste
	    int numero1 = 10;
	    int numero2 = 20;
	    int resultadoEsperado = 30;
	    //executa
	    int resultado = calc.somar(numero1,numero2);
	    //valida resultado
	    if (resultado!=resultadoEsperado){
	      System.out.println("Oops! Deu um resultado não esperado: "+resultado);
	    }
	    else System.out.println("OK! Passou do teste.");
		
		
		
		
	}

}
