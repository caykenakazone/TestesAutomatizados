package pessoa.entity;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = validaNome(nome);
        this.horasTrabalhadas = validaHoras(horasTrabalhadas);
        this.valorHora = validaValorHoras(valorHora);
    }

    public Funcionario() {}

    public String validaNome(String nome){
        if (nome.isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }else{
            return nome;
        }
    }
    public int validaHoras(int horasTrabalhadas){
        if (horasTrabalhadas < 40 && horasTrabalhadas >0) {
            return horasTrabalhadas;
        }else{
            throw new IllegalArgumentException("O número de horas trabalhadas por funcionários próprios deve ser menor ou igual a 40.");
        }
    }
    public double validaValorHoras(double valorHora){
        double salarioMinimo = 1320.00;
        double valorMinimoHora = salarioMinimo * 0.04;
        double valorMaximoHora = salarioMinimo * 0.10;
        if (valorHora>valorMinimoHora && valorHora < valorMaximoHora && valorHora>0){
            return valorHora;
        }else{
            throw new IllegalArgumentException("Valor por hora inválido");
        }
    }

    public double calcularPagamento(){
        double valorHora = getValorHora();
        int horasTrabalhadas = getHorasTrabalhadas();
        double salarioMinimo = 1320.00;
        double pagamento = valorHora * horasTrabalhadas;
        if (pagamento < salarioMinimo) {
            pagamento = salarioMinimo;
        }
        return pagamento;
    }
    public void modificarValorPagamento(double novoValor) {
        double salarioMinimo = 1320.00;
        double valorMinimoHora = salarioMinimo * 0.04;
        double valorMaximoHora = salarioMinimo * 0.10;

        if (novoValor > valorMinimoHora && novoValor < valorMaximoHora){
            this.valorHora = novoValor;
        }else{
            throw new IllegalArgumentException("Valor por hora inválido");
        }

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = validaHoras(horasTrabalhadas);
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = validaValorHoras(valorHora);
    }
}
