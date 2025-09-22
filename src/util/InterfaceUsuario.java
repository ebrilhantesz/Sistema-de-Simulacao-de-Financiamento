package util;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    // Atributos da classe InterfaceUsuario
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Contrutores da classe InterfaceUsuario
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

    // Metodo para pedir a area construida da casa
    public double pedirAreaConstruida() {
        double area;
        do {
            System.out.print("Digite a área construida (m²): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido! Não é um número, digite novamente (ex.: 90.3).");
                scanner.next();
                area = -1;
                continue;
            }
            area = scanner.nextDouble();
            if (area <= 0) {
                System.out.println("Erro! A área construída deve ser maior que zero!");
            }
        } while (area <= 0);
        return area;
    }

    // Metodo para pedir o tamanho do terreno da casa
    public double pedirTamanhoTerreno() {
        double tamanho;
        do {
            System.out.print("Digite o tamanho do terreno (m²): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Valor inválido! Digite um número (ex.: 275.0).");
                scanner.next();
                tamanho = -1;
                continue;
            }
            tamanho = scanner.nextDouble();

            if (tamanho <= 0) {
                System.out.println("Erro! O tamanho do terreno deve ser maior que zero!");
            }
        } while (tamanho <= 0);
        return tamanho;
    }

    // Metodo para pedir a quantidade de vagas da garagem do apartamento
    public int pedirNumeroVagas() {
        int vagas;
        do {
            System.out.print("Digite o número de vagas da garagem: ");
            if (!scanner.hasNextInt()) {
                System.out.println("Valor inválido! Digite um número inteiro (ex.: 2 ou 7).");
                scanner.next();
                vagas = -1;
                continue;
            }
            vagas = scanner.nextInt();

            if (vagas < 0) {
                System.out.println("Erro! O número de vagas não pode ser negativo!");
            }
        } while (vagas < 0);
        return vagas;
    }

    // Metodo para pedir o andar do apartamento
    public int pedirNumeroAndar() {
        int andar;
        do {
            System.out.print("Digite o número do andar (0 para térreo): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Valor inválido! Digite um número inteiro (0 ou mais, ex.: 5 para quinto andar).");
                scanner.next();
                andar = -1;
                continue;
            }
            andar = scanner.nextInt();

            if (andar < 0) {
                System.out.println("Erro! O número do andar não pode ser negativo!");
            }
        } while (andar < 0);
        return andar;
    }

    // Metodo para perguntar o tipo de zona do terreno
    public String pedirTipoZona() {
        int opcao = 0;
        do {
            System.out.print("Digite o tipo de zona (1 - Residencial, 2 - Comercial): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Valor inválido! Digite 1 ou 2.");
                scanner.next();
                continue;
            }
            opcao = scanner.nextInt();

            if (opcao == 1) {
                return "residencial";
            } else if (opcao == 2) {
                return "comercial";
            } else {
                System.out.println("Opção inválida! Digite apenas 1 ou 2.");
            }
        } while (true);
    }

    // Metodo para pedir a quantidade de financiamentos ao usuário
    public int pedirQuantidadeFinanciamentos() {
        int quantidadeFinanciamentos;
        do {
            System.out.print("Quantos financiamentos deseja cadastrar? ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite um número inteiro (ex.: 3 ou 6).");
                scanner.next();
                quantidadeFinanciamentos = -1;
                continue;
            }
            quantidadeFinanciamentos = scanner.nextInt();
            if (quantidadeFinanciamentos <= 0) {
                System.out.println("Erro! Digite um número maior que 0.");
            }
        } while (quantidadeFinanciamentos <= 0);
        return quantidadeFinanciamentos;
    }

    // Metodo para perguntar qual o tipo do financiamento ao usuário
    public int pedirTipoFinanciamento() {
        int tipoFinanciamento;
        do {
            System.out.print("Qual o tipo do financiamento? (1 - Apartamento, 2 - Casa, 3 - Terreno): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Digite 1, 2 ou 3.");
                scanner.next(); // descarta entrada inválida
                tipoFinanciamento = -1;
                continue;
            }
            tipoFinanciamento = scanner.nextInt();
            if (tipoFinanciamento < 1 || tipoFinanciamento > 3) {
                System.out.println("Opção inválida! Digite 1, 2 ou 3.");
            }
        } while (tipoFinanciamento < 1 || tipoFinanciamento > 3);
        return tipoFinanciamento;
    }
}