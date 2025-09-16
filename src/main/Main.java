/*
Aluno: Eduardo Henrique Brilhante
Disciplina: Fundamentos da Programação Orientada a Objetos (POO)
Curso: Superior de Tecnologia em Análise e Desenvolvimento de Sistemas
RA: 1112025201951
 */
package main;
import modelo.Financiamento;
import util.InterfaceUsuario;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Criação de novo objeto(interfaceUsuario) e nova ArrayList(Financiamento)
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamento = new ArrayList<>();

        // Metodo para pedir 4 financiamentos
        for (int i = 1; i <= 4; i++) {
            System.out.println("\n--- Financiamento " + i + " ---");
            double valorImovel = interfaceUsuario.pedirValorImovel();
            int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
            double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

            listaDeFinanciamento.add(new Financiamento(valorImovel, prazoFinanciamento, taxaJurosAnual));
        }

        // Variaveis para calcular os valores totais
        double totalImoveis = 0.0;
        double totalFinanciamentos = 0.0;

        // Metodo para impressão dos resultados dos financiamentos
        System.out.println("\n=== Resumo dos financiamentos ===");
        for (int i = 0; i < listaDeFinanciamento.size(); i++) {
            Financiamento f = listaDeFinanciamento.get(i);
            double valorImovel = f.getValorImovel();
            double valorFinanciamento = f.calcularTotalPagamento();

            totalImoveis += valorImovel;
            totalFinanciamentos += valorFinanciamento;

            System.out.printf("Financiamento %d – valor do imóvel: R$ %.2f. Valor total do financiamento: R$ %.2f%n", i + 1, valorImovel, valorFinanciamento);
        }

        // Metodo para impressão do resultado da soma de todos os financiamentos
        System.out.printf("%nValor total de todos os imóveis: R$ %.2f. Valor total de todos os financiamentos: R$ %.2f%n", totalImoveis, totalFinanciamentos);
    }
}