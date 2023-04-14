package pessoa.entity;

public class FuncionarioTercerizado extends Funcionario{
    private double despesasAdicionais;

    public FuncionarioTercerizado(String nome, int horasTrabalhadas, double valorHora, double despesasAdicionais) {
        super(nome, horasTrabalhadas, valorHora);
        this.despesasAdicionais = validaDespesasAdicionais(despesasAdicionais);
    }


    public double calcularPagamento() {
        double despesasAdicionais = getDespesasAdicionais();
        double salarioMinimo = 1320.00;
        double valorMinimoHora = salarioMinimo * 0.04;
        double valorMaximoHora = salarioMinimo * 0.10;



        double pagamento = super.calcularPagamento() + despesasAdicionais;

        if (pagamento < salarioMinimo) {
            pagamento = salarioMinimo;
        }

        return pagamento;
    }
    public double validaDespesasAdicionais(double despesasAdicionais){
        if (despesasAdicionais > 1000.00 || despesasAdicionais < 0) {
            throw new IllegalArgumentException("Despesas adicionais não podem ser maior que R$1000.");
        }else{
            return despesasAdicionais;
        }
    }

    public double getDespesasAdicionais() {
        return despesasAdicionais;
    }

    public void setDespesasAdicionais(double despesasAdicionais) {
        this.despesasAdicionais = validaDespesasAdicionais(despesasAdicionais);
    }
}
