package modelo;
import java.util.Scanner;

public class Casa extends Financiamento {

    // Atributos da subclasse Casa
    private double areaConstruidaCasa;
    private double tamanhoTerrenoCasa;

    // Construtor da subclasse Casa
    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruidaCasa, double tamanhoTerrenoCasa) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruidaCasa = areaConstruidaCasa;
        this.tamanhoTerrenoCasa = tamanhoTerrenoCasa;
    }

    // Metodos da subclasse Casa

    // Override do pagamento mensal com adição de R$80,00 do seguro obrigatório
    @Override
    public double calcularPagamentoMensal() {
        return super.calcularPagamentoMensal() + 80;
    }

    // Getters da subclasse Casa
    public double getAreaConstruidaCasa() {
        return areaConstruidaCasa;
    }

    public double getTamanhoTerrenoCasa() {
        return tamanhoTerrenoCasa;
    }
}
