package crud.model;

import java.util.Scanner;

public class Cat extends Animal {
    private String color;

    public Cat(String name, int age, String breed, String color) {
        super(name, age, breed);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

        System.out.println("Nova cor: ");
        setColor(sc.nextLine());
    }

    @Override
    public String toString() {
        return super.toString() + ", Cor: " + color;
    }
}
