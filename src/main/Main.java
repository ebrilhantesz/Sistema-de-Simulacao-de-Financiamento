package main;

import modelo.Financiamento;
import modelo.Apartamento;
import modelo.Casa;
import modelo.Terreno;
import util.InterfaceUsuario;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Criação de novo objeto(interfaceUsuario) e nova ArrayList(Financiamento)
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> listaDeFinanciamento = new ArrayList<>();

        // Perguntando ao usuário a quantidade de financiamentos que deseja cadastrar
        int quantidade = interfaceUsuario.pedirQuantidadeFinanciamentos();

        // Metodo para pedir os financiamentos
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
            int meses = f.getPrazoFinanciamento() * 12;
            double valorFinanciamento = parcelaMensal * meses;

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

        // Metodo para impressão do resultado da soma de todos os financiamentos e tambem metodo para impressão da soma das parcelas mensais
        System.out.printf("%nValor total de todos os imóveis: R$ %.2f. Valor total de todos os financiamentos: R$ %.2f%n", totalImoveis, totalFinanciamentos);
        System.out.printf("Soma das parcelas mensais de todos os financiamentos: R$ %.2f%n", somaParcelasMensais);

        // Salvar e ler como texto (arquivo legível)
        String arquivoTexto = "financiamentos.txt";
        salvarComoTexto(listaDeFinanciamento, arquivoTexto);
        lerArquivoTexto(arquivoTexto);

        // Salvar e ler serializado (objeto)
        String arquivoSerializado = "financiamentos.ser";
        salvarSerializado(listaDeFinanciamento, arquivoSerializado);
        List<Financiamento> listaDesserializada = lerSerializado(arquivoSerializado);

        // Imprimir os objetos desserializados
        System.out.println("\n=== Lista Desserializada ===");
        for (int i = 0; i < listaDesserializada.size(); i++) {
            Financiamento f = listaDesserializada.get(i);
            String tipo = (f instanceof Casa) ? "Casa" : (f instanceof Apartamento) ? "Apartamento" : (f instanceof Terreno) ? "Terreno" : "Financiamento";
            System.out.printf("%d) %s - valor: %.2f, prazo: %d, taxa: %.2f%n", i + 1, tipo, f.getValorImovel(), f.getPrazoFinanciamento(), f.getTaxaJurosAnual());
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

    }

    private static void salvarComoTexto(List<Financiamento> lista, String caminho) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
            for (Financiamento f : lista) {
                String linha = montarLinhaTexto(f);
                bw.write(linha);
                bw.newLine();
            }
            System.out.println("\nArquivo de texto salvo em: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo de texto: " + e.getMessage());
        }
    }

    private static String montarLinhaTexto(Financiamento f) {
        if (f instanceof Casa) {
            Casa c = (Casa) f;
            return String.join(";",
                    "CASA",
                    Double.toString(c.getValorImovel()),
                    Integer.toString(c.getPrazoFinanciamento()),
                    Double.toString(c.getTaxaJurosAnual()),
                    Double.toString(c.getAreaConstruidaCasa()),
                    Double.toString(c.getTamanhoTerrenoCasa()));
        } else if (f instanceof Apartamento) {
            Apartamento a = (Apartamento) f;
            return String.join(";",
                    "APARTAMENTO",
                    Double.toString(a.getValorImovel()),
                    Integer.toString(a.getPrazoFinanciamento()),
                    Double.toString(a.getTaxaJurosAnual()),
                    Integer.toString(a.getNumeroVagasGaragemApartamento()),
                    Integer.toString(a.getNumeroAndarApartamento()));
        } else if (f instanceof Terreno) {
            Terreno t = (Terreno) f;
            return String.join(";",
                    "TERRENO",
                    Double.toString(t.getValorImovel()),
                    Integer.toString(t.getPrazoFinanciamento()),
                    Double.toString(t.getTaxaJurosAnual()),
                    t.getTipoZonaTerreno());
        } else {
            return String.join(";",
                    "FINANCIAMENTO",
                    Double.toString(f.getValorImovel()),
                    Integer.toString(f.getPrazoFinanciamento()),
                    Double.toString(f.getTaxaJurosAnual()));
        }
    }

    private static void lerArquivoTexto(String caminho) {
        System.out.println("\nLendo o arquivo de texto: " + caminho);
        try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
            String linha;
            int idx = 1;
            while ((linha = br.readLine()) != null) {
                System.out.println("Linha " + idx + ": " + linha);
                idx++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo de texto: " + e.getMessage());
        }
    }

    private static void salvarSerializado(List<Financiamento> lista, String caminho) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(caminho))) {
            oos.writeObject(lista);
            System.out.println("\nArquivo serializado salvo em: " + caminho);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo serializado: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static List<Financiamento> lerSerializado(String caminho) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(caminho))) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                return (List<Financiamento>) obj;
            } else {
                System.out.println("Objeto lido não é uma lista.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo serializado: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Classe não encontrada ao desserializar: " + e.getMessage());
        }
        return new ArrayList<>();
    }
}