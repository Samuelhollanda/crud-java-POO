package crud.view;

import crud.model.*;
import java.util.Scanner;
import crud.controller.AnimalController;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AnimalController controller = new AnimalController();
        int op;

        do {
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
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
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
