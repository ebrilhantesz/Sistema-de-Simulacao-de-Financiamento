package modelo;

public class Financiamento {

    // Atributos da classe Financiamento
    protected double valorImovel;
    protected int prazoFinanciamento;
    protected double taxaJurosAnual;

    // Getters da classe Financiamento
    public double getValorImovel() {
        return this.valorImovel;
    }

    public int getPrazoFinanciamento() {
        return this.prazoFinanciamento;
    }

    public double getTaxaJurosAnual() {
        return this.taxaJurosAnual;
    }

    // Construtor da classe Financiamento
    public Financiamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        this.valorImovel = valorImovel;
        this.prazoFinanciamento = prazoFinanciamento;
        this.taxaJurosAnual = taxaJurosAnual;
    }

    // Metodos da classe Financiamento

    // Metodo para calcular o pagamento mensal
    public double calcularPagamentoMensal() {
        int meses = this.prazoFinanciamento * 12;
        double taxaMensalDecimal = (this.taxaJurosAnual / 100.0) / 12.0;

        if (taxaMensalDecimal == 0.0){
            return this.valorImovel / meses;
        }

        double parcelaPrincipalMensal = this.valorImovel / meses;
        return parcelaPrincipalMensal * (1.0 + taxaMensalDecimal);
    }

    // Metodo para calcular o valor total do pagamento
    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
}