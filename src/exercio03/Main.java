package exercio03;

import java.util.Scanner;

public class Main {
    static BilheteUnico[] bilhete = new BilheteUnico[3];
    static Scanner sc = new Scanner(System.in);
    static int index = 0;

    public static void main(String[] args) {
        int opcao;


        do {
            System.out.println("[1] cadastrar bilhete");
            System.out.println("[2] carregar bilhete");
            System.out.println("[3] consultar saldo");
            System.out.println("[4] passar na catraca");
            System.out.println("[5] finalizar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> carregar();
                case 3 -> consultarSaldo();
                case 4 -> passarNaCatraca();
                case 5 -> System.out.println("Ate Breve!");
                default -> System.out.println("Opçao Invalida");
            }
            System.out.println("############################################");
        }while (opcao != 5);


    }

    private static void passarNaCatraca() {
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null) {
         if (!bilheteUnico.passarNaCatraca());
            System.out.println("Saldo insuficiente");
        }
        System.out.println("Saldo atual: " + bilheteUnico.saldo);
    }

    private static void consultarSaldo() {
        BilheteUnico bilheteUnico = pesquisar();
        if (bilheteUnico != null) {
            System.out.println("Saldo atual: " + bilheteUnico.saldo);
        }
    }

    private static void carregar() {
        double valor;
        BilheteUnico bilheteUnico = pesquisar();
        if(bilheteUnico != null){
            System.out.print("Valor da recarga: ");
            valor = sc.nextDouble();
            bilheteUnico.carregar(valor);
        }
    }

    private static void cadastrar() {
        String nome;
        long cpf;
        String tipoTarifa;


        if (index < bilhete.length){
            System.out.println(" Nome do usuario: ");
            nome= sc.next();
            System.out.print("CPF: ");
            cpf = sc.nextLong();
            System.out.print("tipo de tarifa (estudante | professor | comum: ");
            tipoTarifa = sc.next();
            bilhete[index] = new BilheteUnico(new Usuario(nome, cpf,tipoTarifa));
            index++;

        }
        else {
            System.out.println("Erro ao gerar o bilhete! Procure umposto de atendimento");
        }
    }

    public static BilheteUnico pesquisar(){
        long cpf;
        System.out.println("CPF para pesquisar: ");
        cpf = sc.nextLong();
        for (int i =0; i <index; i++){
            if (bilhete[i].usuario.cpf == cpf) {
                return bilhete[i];
            }
        }
        System.out.println("Bilhete nao encontrado!");
        return null;
    }

}
