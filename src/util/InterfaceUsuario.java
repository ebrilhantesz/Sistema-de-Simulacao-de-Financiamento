package util;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    // Atributos da classe InterfaceUsuario
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Contrutores da classe InterfaceUsuario
    public InterfaceUsuario(double pedirValorImovel, int pedirPrazoFinanciamento, double pedirTaxaJurosAnual) {
        this.valorImovel = pedirValorImovel;
        this.prazoFinanciamento = pedirPrazoFinanciamento;
        this.taxaJurosAnual = pedirTaxaJurosAnual;
    }
    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Metodos da classe InterfaceUsuario

    // Metodo para pedir o valor do imovel
    public double pedirValorImovel() {
        do {
            System.out.println("Digite o valor do imóvel: ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido! Não é um número!");
                scanner.next();
                continue;
            }
            valorImovel = scanner.nextDouble();

            if (valorImovel <= 0) {
                System.out.println("Erro! O valor do imóvel deve ser maior que zero!");
            }

        } while (valorImovel <= 0);
        return valorImovel;
    }
    // Metodo para pedir o prazo do financiamento
    public int pedirPrazoFinanciamento() {
        do {
            System.out.println("Digite o prazo do financiamento (em anos): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Valor inválido! Não é um número!");
                scanner.next();
                continue;
            }
            prazoFinanciamento = scanner.nextInt();

            if (prazoFinanciamento <= 0) {
                System.out.println("Erro! O prazo do financiamento deve ser maior que zero!");
            }
        } while (prazoFinanciamento <= 0);
        return prazoFinanciamento;
    }

    // Metodo para pedir a taxa de juros
    public double pedirTaxaJurosAnual () {
        do {
            System.out.println("Digite a taxa de juros anual (%): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido! Não é um número!");
                scanner.next();
                continue;
            }
            taxaJurosAnual = scanner.nextDouble();

            if (taxaJurosAnual <= 0) {
                System.out.println("Erro! A taxa de juros deve ser maior que zero!");
            }
        } while (taxaJurosAnual <= 0);
        return taxaJurosAnual;
    }
}