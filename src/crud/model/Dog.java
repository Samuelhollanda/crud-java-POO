package crud.model;

import java.util.Scanner;

public class Dog extends Animal {

    public Dog(String name, int age, String breed) {
        super(name, age, breed);
    }


    @Override
    public void update(Scanner sc) {
        System.out.println("Novo nome: ");
        setName(sc.nextLine());

        System.out.println("Nova idade: ");
        setAge(sc.nextInt());
        sc.nextLine();

        System.out.println("Nova raça: ");
        setBreed(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}