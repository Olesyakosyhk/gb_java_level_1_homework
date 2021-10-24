package hw6;

public class Animal {
    protected String name;
    protected int maxRunDistance;
    protected int maxSwimDistance;

    static int totalCount;

    public Animal(String name) {
        totalCount++;

        this.name = name;
    }

    public void run(int distance) {
        if (distance > this.maxRunDistance){
            System.out.printf("%s не может пробежать больше %s м.\n", this.name, this.maxRunDistance);
        } else {
            System.out.printf("%s пробежал %s м.\n", this.name, distance);
        }
    }

    public void swim(int distance) {
        if (distance > this.maxSwimDistance){
            System.out.printf("%s не  может проплыть больше %s м.\n", this.name, this.maxSwimDistance);
        } else {
            System.out.printf("%s проплыл %s м.\n", this.name, distance);
        }
    }
}