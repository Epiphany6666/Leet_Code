package homework.实验6;

public class Cat {
    private String name;
    private double weight;
    private int age;
    private String furColor;
    private String breed;

    public Cat(String name, double weight, int age, String furColor, String breed) {
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.furColor = furColor;
        this.breed = breed;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }

    public void play() {
        System.out.println(name + " is playing.");
    }

    public static void main(String[] args) {
        Cat cat = new Cat("Tom", 3.5, 3, "white", "domestic");
        cat.eat();
        cat.sleep();
        cat.play();
    }
}