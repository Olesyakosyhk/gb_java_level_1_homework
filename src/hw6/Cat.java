package  hw6;

public  class Cat extends Animal {
    static int totalCount;

    public Cat (String name) {
        super(name);

        this.maxRunDistance = 200;
        totalCount++;
    }

    @Override
    public void swim(int distance) {
        System.out.printf("%s не умеет плавать :(.\n", this.name);
    }
}