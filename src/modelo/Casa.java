package modelo;

public class Casa extends Financiamento {

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    // Override do pagamento mensal com adição de R$80,00 do seguro obrigatório
    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() + 80;
    }
}
