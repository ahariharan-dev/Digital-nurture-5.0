class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Bark");
    }
}

public class InheritanceExample {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();

        System.out.print("Animal sound: ");
        animal.makeSound();

        System.out.print("Dog sound: ");
        dog.makeSound();
    }
}
