// src/crud/controller/AnimalController.java
package crud.controller;

import crud.model.*;
import java.util.ArrayList;
import java.util.List;

public class AnimalController {
    private final List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal a) {
        animals.add(a);
    }

    public List<Animal> listAnimal() {
        return new ArrayList<>(animals);
    }

    public boolean deleteAnimalById(int id) {
        if (id >= 0 && id < animals.size()) {
            animals.remove(id);
            return true;
        }
        return false;
    }

    // Novo método para atualização a partir da GUI
    public boolean updateAnimal(int id, String name, Integer age, String breed, String color) {
        if (id < 0 || id >= animals.size()) return false;
        Animal a = animals.get(id);
        if (name != null && !name.isBlank()) a.setName(name);
        if (age != null) a.setAge(age);
        if (breed != null && !breed.isBlank()) a.setBreed(breed);
        if (color != null && a instanceof Cat) ((Cat) a).setColor(color);
        return true;
    }
}
