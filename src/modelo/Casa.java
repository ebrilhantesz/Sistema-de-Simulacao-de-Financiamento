package modelo;

import util.AumentoMaiorDoQueJurosException;

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

    // Metodo para tratamento de exceção quando o valor do acréscimo de R$ 80 for maior do que a metade do valor dos juros da mensalidade
    private void validarAumentoMaiorDoQueJuros(double valorJuros, double valorAcrescimo) throws AumentoMaiorDoQueJurosException{
        if(valorAcrescimo > valorJuros) {
            throw new AumentoMaiorDoQueJurosException("O acréscimo de R$ " + valorAcrescimo + " foi maior que o valor dos juros (R$ " + valorJuros + ").");
        }
    }

    // Override do pagamento mensal com adição de R$80,00 do seguro obrigatório e tambem tratamento da exceção
    @Override
    public double calcularPagamentoMensal() {
        double parcelaBase = super.calcularPagamentoMensal();
        int meses = prazoFinanciamento * 12;

        double parcelaPrincipalMensal = valorImovel / meses;
        double jurosMensal = parcelaBase - parcelaPrincipalMensal;
        double acrescimo = 80;

        try {
            validarAumentoMaiorDoQueJuros(jurosMensal, acrescimo);
        } catch(AumentoMaiorDoQueJurosException e) {
            System.out.println("Erro! " + e.getMessage());
            System.out.printf("O acréscimo foi ajustado para R$ %.2f.%n", jurosMensal);
            acrescimo = jurosMensal;
        }
        return parcelaBase + acrescimo;
    }

    // Getters da subclasse Casa
    public double getAreaConstruidaCasa() {
        return areaConstruidaCasa;
    }

    public double getTamanhoTerrenoCasa() {
        return tamanhoTerrenoCasa;
    }
}
