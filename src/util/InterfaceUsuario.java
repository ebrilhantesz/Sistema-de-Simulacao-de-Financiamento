package util;

import java.util.Scanner;
import java.util.InputMismatchException; // usado para caso a entrada fornecida não corresponda ao esperado, no caso, os números/dados para criação do financiamento

public class InterfaceUsuario {
    Scanner scanner;

    // Atributos da classe InterfaceUsuario
    private double valorImovel;
    private int prazoFinanciamento;
    private double taxaJurosAnual;

    // Contrutores da classe InterfaceUsuario
    public InterfaceUsuario() {
        this.scanner = new Scanner(System.in);
    }

    // Metodos da classe InterfaceUsuario

    // Metodo para pedir o valor do imovel usando o tratamento de exceções
    public double pedirValorImovel() {
        double valor = -1;
        do {
            try {
                System.out.print("Digite o valor do imóvel: ");
                valor = scanner.nextDouble();

                if (valor <= 0) {
                    System.out.println("Valor inválido! O valor do imóvel deve ser maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Não é um número. Digite novamente (ex.: 175000 ou 350000).");
                scanner.next(); // para descartar entrada inválida
                valor = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // para descartar entrada inválida
                valor = -1;
            } finally {
            }
        } while (valor <= 0);

        this.valorImovel = valor;
        return valor;
    }

    // Metodo para pedir o prazo do financiamento usando o tratamento de exceções
    public int pedirPrazoFinanciamento() {
        int prazo = -1;
        do {
            try {
                System.out.println("Digite o prazo do financiamento (em anos): ");
                prazo = scanner.nextInt();

                if (prazo <= 0) {
                    System.out.println("Valor inválido! O prazo do financiamento deve ser maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número inteiro (ex.: 10 ou 15).");
                scanner.next(); // para descartar entrada inválida
                prazo = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // para descartar entrada inválida
                prazo = -1;
            } finally {
            }
        } while (prazo <= 0);

        this.prazoFinanciamento = prazo;
        return prazo;
    }

    // Metodo para pedir a taxa de juros usando o tratamento de exceções
    public double pedirTaxaJurosAnual () {
        double taxa = -1;
        do {
            try {
                System.out.println("Digite a taxa de juros anual (%): ");
                taxa = scanner.nextDouble();

                if (taxa <= 0) {
                    System.out.println("Valor inválido! A taxa de juros deve ser maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número (ex.: 5 ou 7,5).");
                scanner.next(); // para descartar entrada inválida
                taxa = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // para descartar entrada inválida
                taxa = -1;
            } finally {
            }
        } while (taxa <= 0);

        this.taxaJurosAnual = taxa;
        return taxa;
    }

    // Metodo para pedir a area construida da casa usando o tratamento de exceções
    public double pedirAreaConstruida() {
        double area;
        do {
            try {
                System.out.print("Digite a área construida (m²): ");
                area = scanner.nextDouble();

                if (area <= 0) {
                    System.out.println("Valor inválido! A área construída deve ser maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Não é um número, digite novamente (ex.: 65 ou 90,3).");
                scanner.next(); // para descartar entrada inválida
                area = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // para descartar entrada inválida
                area = -1;
            } finally {
            }
        } while (area <= 0);
        return area;
    }

    // Metodo para pedir o tamanho do terreno da casa usando o tratamento de exceções
    public double pedirTamanhoTerreno() {
        double tamanho = -1;
        do {
            try {
                System.out.print("Digite o tamanho do terreno (m²): ");
                tamanho = scanner.nextDouble();

                if (tamanho <= 0) {
                    System.out.println("Valor inválido! O tamanho do terreno deve ser maior que zero!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número (ex.: 150 ou 265,0).");
                scanner.next(); // para descartar entrada inválida
                tamanho = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // para descartar entrada inválida
                tamanho = -1;
            } finally {
            }
        } while (tamanho <= 0);
        return tamanho;
    }

    // Metodo para pedir a quantidade de vagas da garagem do apartamento usando o tratamento de exceções
    public int pedirNumeroVagas() {
        int vagas = -1;
        do {
            try {
                System.out.print("Digite o número de vagas da garagem: ");
                vagas = scanner.nextInt();

                if (vagas < 0) {
                    System.out.println("Valor inválido! O número de vagas não pode ser negativo!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número inteiro (0 ou mais, ex.: 2 ou 7).");
                scanner.next(); // para descartar entrada inválida
                vagas = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado : " + e.getMessage());
                scanner.next(); // para descartar entrada inválida
                vagas = -1;
            } finally {
            }
        } while (vagas < 0);
        return vagas;
    }

    // Metodo para pedir o andar do apartamento usando o tratamento de exceções
    public int pedirNumeroAndar() {
        int andar = -1;
        do {
            try {
                System.out.print("Digite o número do andar (0 para térreo): ");
                andar = scanner.nextInt();

                if (andar < 0) {
                    System.out.println("Erro! O número do andar não pode ser negativo!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número inteiro (0 ou mais, ex.: 5 para quinto andar).");
                scanner.next(); // para descartar entrada inválida
                andar = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // para descartar entrada inválida
                andar = -1;
            } finally {
            }
        } while (andar < 0);
        return andar;
    }

    // Metodo para perguntar o tipo de zona do terreno usando o tratamento de exceções
    public String pedirTipoZona() {
        int opcaoZona = -1;
        do {
            try {
                System.out.print("Digite o tipo de zona (1 - Residencial, 2 - Comercial): ");
                opcaoZona = scanner.nextInt();

                if (opcaoZona == 1) {
                    return "residencial";
                } else if (opcaoZona == 2) {
                    return "comercial";
                } else {
                    System.out.println("Opção inválida! Digite apenas 1 ou 2.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite 1 ou 2.");
                scanner.next(); // Para descartar entradas inválidas
                opcaoZona = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // Para descartar entradas inválidas
                opcaoZona = -1;
            } finally {
            }
        } while (true);
    }

    // Metodo para pedir a quantidade de financiamentos ao usuário usando o tratamento de exceções
    public int pedirQuantidadeFinanciamentos() {
        int quantidadeFinanciamentos = -1;
        do {
            try {
                System.out.print("Quantos financiamentos deseja cadastrar? ");
                quantidadeFinanciamentos = scanner.nextInt();

                if (quantidadeFinanciamentos <= 0) {
                    System.out.println("Erro! Digite um número maior que zero.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite um número inteiro (ex.: 3 ou 7).");
                scanner.next(); // Para descartar entradas inválidas
                quantidadeFinanciamentos = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado : " + e.getMessage());
                scanner.next(); // Para descartar entradas inválidas
                quantidadeFinanciamentos = -1;
            } finally {
            }
        } while (quantidadeFinanciamentos <= 0);
        return quantidadeFinanciamentos;
    }

    // Metodo para perguntar qual o tipo do financiamento ao usuário usando o tratamento de exceções
    public int pedirTipoFinanciamento() {
        int tipoFinanciamento = -1;
        do {
            try {
                System.out.print("Qual o tipo do financiamento? (1 - Apartamento, 2 - Casa, 3 - Terreno): ");
                tipoFinanciamento = scanner.nextInt();

                if (tipoFinanciamento < 1 || tipoFinanciamento > 3) {
                    System.out.println("Opção inválida! Digite 1, 2 ou 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido! Digite 1, 2 ou 3.");
                scanner.next(); // Para descartar entradas inválidas
                tipoFinanciamento = -1;
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                scanner.next(); // Para descartar entradas inválidas
                tipoFinanciamento = -1;
            } finally {
            }
        } while (tipoFinanciamento < 1 || tipoFinanciamento > 3);
        return tipoFinanciamento;
    }
}