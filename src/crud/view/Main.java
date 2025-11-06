package crud.view;

import crud.model.Animal;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = Inp
        Animal novoAnimal = new Animal("Josias", 21, "Dog");
        novoAnimal.showInfo();
        System.out.println("Test");
        int op = 2;


        switch (op) {
            case 1:
                System.out.println("Hello Word!!");
                break;
            case 2:
                System.out.println("Word Hello");
                break;
        }
    }
}
