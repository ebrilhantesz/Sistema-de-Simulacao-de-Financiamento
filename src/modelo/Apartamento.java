package modelo;

import java.io.Serializable;

public class Apartamento extends Financiamento implements Serializable {
    private static final long serialVersionUID = 1L;

    // Atributos da classe apartamento
    private int numeroVagasGaragemApartamento;
    private int numeroAndarApartamento;

    // Construtor da subclasse apartamento
    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numeroVagasGaragemApartamento, int numeroAndarApartamento) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numeroVagasGaragemApartamento = numeroVagasGaragemApartamento;
        this.numeroAndarApartamento = numeroAndarApartamento;
    }

    // Metodos da subclasse apartamento

    // Override do pagamento mensal com nova fórmula para sistema de amortização (PRICE)
    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = (this.taxaJurosAnual / 100.00) / 12.0;         // Para calcular primeiro a taxa mensal
        int meses = this.prazoFinanciamento * 12;                          // Para calcular o valor em meses do financiamento

        // Para caso a taxa seja 0%, evitando a divisão por zero
        if (taxaMensal == 0.0){
            return this.valorImovel / meses;
        }

        double pow = Math.pow(1.0 + taxaMensal, meses);                    // Convertendo para fórmula (1 + taxaMensal) ^ meses
        double mensal = this.valorImovel * (taxaMensal * pow) / (pow - 1);
        return mensal;
    }

    // Getters da subclasse Apartamento
    public int getNumeroVagasGaragemApartamento() {
        return numeroVagasGaragemApartamento;
    }

    public int getNumeroAndarApartamento() {
        return numeroAndarApartamento;
    }

    public String toString() {
        StringBuilder ap = new StringBuilder();

        ap.append(getValorImovel()).append("\n");
        ap.append(getPrazoFinanciamento()).append("\n");
        ap.append(getTaxaJurosAnual()).append("\n");
        ap.append(getNumeroAndarApartamento()).append("\n");
        ap.append(getNumeroVagasGaragemApartamento()).append("\n");

        return ap.toString();
    }
}
