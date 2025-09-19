package modelo;

public class Terreno extends Financiamento {

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

    // Override do pagamento mensal com adição de 2% sobre o valor com juros
    @Override
    public double calcularPagamentoMensal() {
        double parcelaComJuros = super.calcularPagamentoMensal();
        return parcelaComJuros * 1.02;
    }
}
