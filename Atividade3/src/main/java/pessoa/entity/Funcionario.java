package pessoa.entity;

public class Funcionario {
    private String nome;
    private int horasTrabalhadas;
    private double valorHora;

    public Funcionario(String nome, int horasTrabalhadas, double valorHora) {
        this.nome = nome;
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public Funcionario() {}

    public double calcularPagamento(){
        double valorHora = getValorHora();
        int horasTrabalhadas = getHorasTrabalhadas();
        double salarioMinimo = 1320.00;
        double valorMinimoHora = salarioMinimo * 0.04;
        double valorMaximoHora = salarioMinimo * 0.10;

        if (horasTrabalhadas > 40) {
            throw new IllegalArgumentException("O número de horas trabalhadas por funcionários próprios deve ser menor ou igual a 40.");
        }

        if (valorHora<valorMinimoHora || valorHora > valorMaximoHora){
            throw new IllegalArgumentException("Valor por hora inválido");
        }

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

        if (novoValor < valorMinimoHora || novoValor > valorMaximoHora){
            throw new IllegalArgumentException("Valor por hora inválido");
        }

        this.valorHora = novoValor;
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
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }
}
