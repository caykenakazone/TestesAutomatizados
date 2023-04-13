package pessoa.entity;

public class FuncionarioTercerizado extends Funcionario{
    private double despesasAdicionais;
    public double calcularPagamento() {
        double despesasAdicionais = getDespesasAdicionais();
        double salarioMinimo = 1320.00;
        double valorMinimoHora = salarioMinimo * 0.04;
        double valorMaximoHora = salarioMinimo * 0.10;

        if (despesasAdicionais > 1000.00) {
            throw new IllegalArgumentException("Despesas adicionais não podem ser maior que R$1000.");
        }

        double pagamento = super.calcularPagamento() + despesasAdicionais;

        if (pagamento < salarioMinimo) {
            pagamento = salarioMinimo;
        }

        return pagamento;
    }

    public FuncionarioTercerizado(double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }

    public double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(double despesasAdicionais) {
        this.despesasAdicionais = despesasAdicionais;
    }
}
