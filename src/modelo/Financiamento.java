package modelo;

public class Financiamento {

    // Atributos da classe Financiamento
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

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
        return (this.valorImovel / (this.prazoFinanciamento * 12)) * (1 + (this.taxaJurosAnual / 12));
    }

    // Metodo para calcular o valor total do pagamento
    public double calcularTotalPagamento() {
        return this.calcularPagamentoMensal() * this.prazoFinanciamento * 12;
    }
}