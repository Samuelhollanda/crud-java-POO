package crud.view;

import crud.model.Animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type a option: ");
        int op = scanner.nextInt();
        switch (op) {
            case 1:
                System.out.println("You chose an option 1.");
                break;
            case 2:
                System.out.println("You chose an option 2.");
                break;

        }
    }
}
