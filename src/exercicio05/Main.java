package exercicio05;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner sc= new Scanner(System.in);
    static Veiculo[] veiculos = new Veiculo[10];
    static Controle[] controles = new Controle[20];
    static int indexVeiculo;
    static int indexControle;


    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("""
#### Estacionamento ParkEasy ####
[1] Entrada de veículo
[2] Saída de veículo
[3] Imprimir veículos estacionados
[4] Imprimir a receita
[5] Finalizar
                    """);
            opcao = sc.nextInt();
            switch (opcao){
                case 1 -> registrarEntrada();
                case 2 -> veiculosEstacionados();

            }
        }while (opcao != 5);

    }
    public static void veiculosEstacionados(){
        for (int i = 0; i < indexControle; i++) {
            System.out.println(controles[i].veiculo.placa);
        }
    }
    public static void registrarEntrada(){
        String placa,marca, modelo;
        String nome;
        long cpf;
        String horaEntrada;
        Veiculo veiculo = pesquisar();

        if (veiculo == null) {
            System.out.println("Placa --> ");
            placa = sc.next().toUpperCase();
            System.out.println("Modelo --> ");
            modelo = sc.next().toUpperCase();
            System.out.println("Marca --> ");
            marca = sc.next().toUpperCase();
            System.out.println("Nome do Proprietario --> ");
            nome = sc.next();
            System.out.println("CPF do proprietario --> ");
            cpf = sc.nextLong();
            Proprietario proprietario = new Proprietario(nome, cpf);
            veiculos[indexVeiculo] = new Veiculo(placa,marca,modelo, proprietario);
            indexVeiculo++;
        }
        System.out.println("Hora de entrda (hh:mm) --> ");
        horaEntrada = sc.next();
        controles[indexControle] = new Controle(veiculo,horaEntrada);
        indexControle++;
    }
    public static Veiculo pesquisar(){
        String placa;
        System.out.print("Placa para pesquisar --> ");
        placa = sc.next().toUpperCase();
        for (int i = 0; i < indexVeiculo; i++){
            if (veiculos[i].placa.equals(placa)){
                return veiculos[i];
            }
        }
        System.out.println("Placa nao encontrada");
        return null;
    }

}

