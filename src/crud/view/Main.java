package crud.view;

import crud.model.*;

import java.util.Scanner;

import crud.controller.AnimalController;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnimalController controller = new AnimalController();
        int op;
        String name, breed, color;
        int age;

        do {
            System.out.println("--CADASTRO DE ANIMAIS--");
            System.out.println("1 - Cadastrar Gato.");
            System.out.println("2 - Cadastrar Cachorro");
            System.out.println("3 - Listar animais");
            System.out.println("4 - Atualizar animais");
            System.out.println("5 - Remover animal");
            System.out.println("Digite uma opção: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    System.out.println("Digite o nome do Gato: ");
                    name = sc.nextLine();
                    System.out.println("Digite a idade: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a raça: ");
                    breed = sc.nextLine();
                    System.out.println("Digite a cor: ");
                    color = sc.nextLine();
                    controller.addAnimal(new Cat(name, age, breed, color));
                    System.out.println("Gato Cadastrado: ");
                    break;
                case 2:
                    System.out.println("Digite o nome do cachorro: ");
                    name = sc.nextLine();
                    System.out.println("Digite a idade: ");
                    age = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a raça: ");
                    breed = sc.nextLine();
                    controller.addAnimal(new Dog(name, age, breed));
                    System.out.println("Cachorro cadastrado");
                    break;
                case 3:
                    System.out.println("ANIMAIS CADASTRADOS");
                    var list = controller.listAnimal();
                    if (list.isEmpty())
                        System.out.println("Nenhum registro");
                    else {
                        for (int i = 0; i < list.size(); i++)
                            System.out.println(i + " - " + list.get(i));
                    }
                    break;
                case 4:
                    System.out.println("4");
                    break;
                case 5:
                    System.out.println("5");
                    break;
                case 0:
                    System.out.println("0");
                    break;
                default:
                    System.out.println("default");
                    break;
            }
        } while (op != 0);
    }
}
