package crud.controller;

import crud.model.Animal;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {
    private List<Animal> animals = new ArrayList<>();

    //CREATE ANIMAL
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    //LIST ANIMALS
    public List<Animal> listAnimal() {
        return animals;
    }

    //UPDATE ANIMALS
    public boolean updateAnimal(int id, String newName, int newAge, String newBreed) {
        if (id >= 0 && id < animals.size()) {
            Animal a = animals.get(id);
            a.setName(newName);
            a.setAge(newAge);
            a.setBreed(newBreed);
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