package crud.view;

import crud.model.Animal;

public class Main {
    public static void main(String[] args) {
        Animal novoAnimal = new Animal("Josias", 21, "Dog");
        novoAnimal.showInfo();
        System.out.println("Test");
    }
}
