/*
Задание.
1. Создать  классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия. Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание: кот не умеет плавать, собака 10 м.).
4. * Добавить подсчет созданных котов, собак и животных.
*/

package hw6;

public class HomeWork6 {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Компот");
        Cat cat2 = new Cat("Коржик");
        Cat cat3 = new Cat("Карамелька");

        Dog dog1 = new Dog("Дружок");
        Dog dog2 = new Dog("Малыш");

        cat1.run(100);
        cat1.swim(200);
        cat3.run(100);
        dog2.run(100);


        System.out.println(Animal.totalCount);
        System.out.println(Cat.totalCount);
        System.out.println(Dog.totalCount);

    }
}