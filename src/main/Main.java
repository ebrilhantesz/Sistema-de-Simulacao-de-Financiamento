package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criação de novo objeto(interfaceUsuario) e nova ArrayList(Financiamento)
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamento = new ArrayList<>();

        // Perguntando ao usuário a quantidade de financiamentos que deseja cadastrar
        int quantidade = interfaceUsuario.pedirQuantidadeFinanciamentos();

        // Metodo para pedir 5 financiamentos
        for (int i = 1; i <= quantidade; i++) {
            System.out.println("\n--- Financiamento " + i + " ---");

            // Primeiro o usuário escolhe o tipo (Apartamento, Casa ou Terreno)
            int tipoEscolhido = interfaceUsuario.pedirTipoFinanciamento();

            // Realiza a leitura dos campos comuns a todos os tipos de financiamentos
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            // Dependendo do tipo, chama os atributos específicos e instancia a subclasse em questão
            Financiamento novoFinanciamento = null;
            if (tipoEscolhido == 1) {

                // Se for Apartamento
                int numeroVagasGaragem = interfaceUsuario.pedirNumeroVagas();
                int numeroAndar = interfaceUsuario.pedirNumeroAndar();
                novoFinanciamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, numeroVagasGaragem, numeroAndar);

            } else if (tipoEscolhido == 2) {

                // Se for Casa
                double areaConstruida = interfaceUsuario.pedirAreaConstruida();
                double tamanhoTerreno = interfaceUsuario.pedirTamanhoTerreno();
                novoFinanciamento = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, areaConstruida, tamanhoTerreno);

            } else if (tipoEscolhido == 3) {

                // Se for Terreno
                String tipoZona = interfaceUsuario.pedirTipoZona();
                novoFinanciamento = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, tipoZona);
            } else {

                // Por garantia, mas não deve ocorrer por conta da validação em InterfaceUsuario
                System.out.println("Tipo inválido!");
            }

            // adiciona à lista se foi criado corretamente
            if (novoFinanciamento != null) {
                listaDeFinanciamento.add(novoFinanciamento);
            }
        }

        // Variaveis para calcular os valores totais
        double totalImoveis = 0.0;
        double totalFinanciamentos = 0.0;
        double somaParcelasMensais = 0.0;

        // Metodo para impressão dos resultados dos financiamentos, e também do tipo (casa/AP/terreno)
        System.out.println("\n=== Resumo dos financiamentos ===");
        for (int i = 0; i < listaDeFinanciamento.size(); i++) {
            Financiamento f = listaDeFinanciamento.get(i);
            double valorImovel = f.getValorImovel();
            double parcelaMensal = f.calcularPagamentoMensal();
            double valorFinanciamento = f.calcularTotalPagamento();

            totalImoveis += valorImovel;
            totalFinanciamentos += valorFinanciamento;
            somaParcelasMensais += parcelaMensal;

            // Metodo para descobrir o tipo do financiamento para impressão
            String tipo;
            if (f instanceof Casa) tipo = "Casa";
            else if (f instanceof Apartamento) tipo = "Apartamento";
            else if (f instanceof Terreno) tipo = "Terreno";
            else tipo = "Financiamento";

            // Metodo para impressão dos resultados dos financiamentos
            System.out.printf("Financiamento %d (%s) – valor do imóvel: R$ %.2f, parcela mensal: R$ %.2f, valor total do financiamento: R$ %.2f%n", i + 1, tipo, valorImovel, parcelaMensal, valorFinanciamento);

            // Metodo para impressão dos atributos especificos de cada financiamento
            if (f instanceof Casa) {
                Casa c = (Casa) f;
                System.out.printf("    Área construída: %.2f m², Tamanho do terreno: %.2f m²%n", c.getAreaConstruidaCasa(), c.getTamanhoTerrenoCasa());
            } else if (f instanceof Apartamento) {
                Apartamento a = (Apartamento) f;
                System.out.printf("    Vagas: %d, Andar: %d%n", a.getNumeroVagasGaragemApartamento(), a.getNumeroAndarApartamento());
            } else if (f instanceof Terreno) {
                Terreno t = (Terreno) f;
                System.out.printf("    Tipo da zona: %s%n", t.getTipoZonaTerreno());
            }
        }

        // Metodo para impressão do resultado da soma de todos os financiamentos
        System.out.printf("%nValor total de todos os imóveis: R$ %.2f. Valor total de todos os financiamentos: R$ %.2f%n", totalImoveis, totalFinanciamentos);
        System.out.printf("Soma das parcelas mensais de todos os financiamentos: R$ %.2f%n", somaParcelasMensais);
    }
}
