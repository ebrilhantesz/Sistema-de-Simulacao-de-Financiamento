package modelo;

public class Apartamento extends Financiamento {

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
    }

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
}
