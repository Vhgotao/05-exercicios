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
            System.out.println("[3] consultar bilhete");
            System.out.println("[4] passar na catraca");
            System.out.println("[5] finalizar");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> cadastrar();
            }

        }while (opcao != 5);


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
            bilhete[index] = new BilheteUnico(new Usuario(cpf, nome, tipoTarifa));
            index++;
        }
    }

}
