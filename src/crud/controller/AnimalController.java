package crud.controller;

import crud.model.Animal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AnimalController {
    final List<Animal> animals = new ArrayList<>();

    //CREATE ANIMAL
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    //LIST ANIMALS
    public List<Animal> listAnimal() {
        return animals;
    }

    //UPDATE ANIMALS
    public boolean updateAnimal(int id, Scanner sc) {
        if (id >= 0 && id < animals.size()) {
            animals.get(id).update(sc);
            return true;
        }
        return false;
    }

    //DELETE ANIMAL
    public boolean deleteAnimalById(int id) {
        if (id >= 0 && id < animals.size()) {
            animals.remove(id);
            return true;
        }
        return false;
    }
}