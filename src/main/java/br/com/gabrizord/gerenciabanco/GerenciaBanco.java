package br.com.gabrizord.gerenciabanco;


/**
 *
 * @author Gabrizord
 */
import java.util.Scanner;

public class GerenciaBanco {

    public static class Conta {
        private final String nome;
        private final String sobrenome;
        private final String cpf;
        private double saldo;

        public Conta(String nome, String sobrenome, String cpf, double saldoInicial) {
            this.nome = nome;
            this.sobrenome = sobrenome;
            this.cpf = cpf;
            this.saldo = saldoInicial;
        }

        public double consultarSaldo() {
            return saldo;
        }

        public void realizarDeposito(double valor) {
            if (valor > 0) {
                saldo += valor;
                System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
            } else {
                System.out.println("Valor de depósito inválido. O valor deve ser maior que zero.");
            }
        }

        public boolean realizarSaque(double valor) {
            if (valor > 0 && saldo >= valor) {
                saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso.");
                return true;
            } else {
                System.out.println("Saldo insuficiente ou valor de saque inválido. Não é possível realizar o saque.");
                return false;
            }
        }

        public String getNome() {
            return nome;
        }

        public String getSobrenome() {
            return sobrenome;
        }

        public String getCpf() {
            return cpf;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Digite o nome: ");
            String nome = scanner.next();

            System.out.print("Digite o sobrenome: ");
            String sobrenome = scanner.next();

            System.out.print("Digite o CPF: ");
            String cpf = scanner.next();

            System.out.print("Digite o saldo inicial: ");
            double saldoInicial = scanner.nextDouble();

            Conta minhaConta = new Conta(nome, sobrenome, cpf, saldoInicial);
            menu(minhaConta);
        }
    }

    private static void menu(Conta conta) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("============== Menu Principal ==============");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Consultar Saldo");
            System.out.println("2 - Realizar Depósito");
            System.out.println("3 - Realizar Saque");
            System.out.println("4 - Sair");
            System.out.println("============================================");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Saldo atual: R$" + conta.consultarSaldo());
                    break;
                case 2:
                    System.out.print("Digite o valor do depósito: R$");
                    double valorDeposito = scanner.nextDouble();
                    conta.realizarDeposito(valorDeposito);
                    break;
                case 3:
                    System.out.print("Digite o valor do saque: R$");
                    double valorSaque = scanner.nextDouble();
                    if (conta.realizarSaque(valorSaque)) {
                        break;
                    } else {
                        System.out.println("Saldo insuficiente para o saque.");
                    }
                    break;
                case 4:
                    System.out.println("Saindo do programa. Obrigado por usar nossos serviços.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
                    break;
            }
        }
    }
}
