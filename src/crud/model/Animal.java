package crud.model;

import java.sql.SQLOutput;

public class Animal {
    private String name;
    private int age;
    private String breed;

    public Animal(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getBreed() {
        return "breed";
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    @Override
    public String toString() {
        return "[" + getBreed() + "] Name: " + name + ", Age: " + age;
    }
    //method test
    public void showInfo() {
        System.out.println("Your pet:");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Breed: " + breed);
    }
}
