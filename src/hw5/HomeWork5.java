/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */

package hw5;

public class HomeWork5 {

    public static void main(String[] args) {

        //  4. Создать массив из 5 сотрудников.
        Employee[] emps = new Employee[5];

        emps[0] = new Employee("Вася", "директор","lox@gmail.com", "112", "0", 46);
        emps[1] = new Employee("Вася1", "директор1","lox1@gmail.com", "14t12", "10", 64);
        emps[2] = new Employee("Вася2", "директор2","lox2@gmail.com", "1612", "110", 51);
        emps[3] = new Employee("Вася3", "директор3","lox3@gmail.com", "1142", "11111", 39);
        emps[4] = new Employee("Вася4", "директор4","lox4@gmail.com", "1612", "1110", 13);

        //5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
        for(int i = 0; i<5; i++){
            if(emps[i].getAge() > 40){
                emps[i].printInfo();
            }
        }
    }

}


//1.  Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
class Employee {
    private String fullName;
    private String position;
    private String email;
    private String phone;
    private String salary;
    private int age;

    //2. Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String fullName, String position, String email, String phone, String salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    //3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void printInfo(){
        System.out.printf(
                "Full name: %s\nPosition: %s\nEmail: %s\nPhone: %s\nSalary: %s\nAge: %s\n\n",
                this.fullName,
                this.position,
                this.email,
                this.phone,
                this.salary,
                this.age
        );
    }

    public int getAge(){
        return this.age;
    }
}

