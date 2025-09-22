package modelo;

public class Terreno extends Financiamento {

    // Atributos da subclasse Terreno
    private String tipoZonaTerreno;

    // Construtor da subclasse terreno
    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZonaTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZonaTerreno = tipoZonaTerreno;
    }

    // Metodos da subclasse terreno

    // Override do pagamento mensal com adição de 2% sobre o valor com juros
    @Override
    public double calcularPagamentoMensal() {
        double parcelaComJuros = super.calcularPagamentoMensal();
        return parcelaComJuros * 1.02;
    }

    // Getters da subclasse Terreno
    public String getTipoZonaTerreno(){
        return tipoZonaTerreno;
    }
}
