package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Criação de novo objeto(interfaceUsuario) e nova ArrayList(Financiamento)
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamento = new ArrayList<>();

        // Metodo para pedir 4 financiamentos
        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Financiamento " + i + " ---");
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            Financiamento tipoFinanciamento;
            if (i == 1 || i == 2) {
                tipoFinanciamento = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual);
            } else if (i == 3 || i == 4) {
                tipoFinanciamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual);
            } else {
                tipoFinanciamento = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual);
            }

            listaDeFinanciamento.add(tipoFinanciamento);
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

            System.out.printf("Financiamento %d (%s) – valor do imóvel: R$ %.2f, parcela mensal: R$ %.2f, valor total do financiamento: R$ %.2f%n", i + 1, tipo, valorImovel, parcelaMensal, valorFinanciamento);
        }

        // Metodo para impressão do resultado da soma de todos os financiamentos
        System.out.printf("%nValor total de todos os imóveis: R$ %.2f. Valor total de todos os financiamentos: R$ %.2f%n", totalImoveis, totalFinanciamentos);
    }
}