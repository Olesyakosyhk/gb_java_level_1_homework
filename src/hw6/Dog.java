package hw6;

public class Dog extends Animal {
    static int totalCount;

    Dog (String name) {
        super(name);

        this.maxRunDistance = 500;
        this.maxSwimDistance = 10;
        totalCount++;
    }
}