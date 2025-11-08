package crud.model;

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
    public String toString() {
        return super.toString() + ", Cor: " + color;
    }
}
