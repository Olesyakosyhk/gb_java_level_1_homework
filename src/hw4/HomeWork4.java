/*
    Домашняя работа №4
    Крестики нолики
    Особенности:
        - Размер поля конфигурируется при запуске
        - Победная комбинация конфигурируется при запуске
        - Имеется очистка  экрана
        - Поиск победной комбинации при различной размерности.
*/

package hw4;

import java.io.IOException;

import java.util.Random;
import java.util.Scanner;


public class HomeWork4 {

    public static int SIZE = 0;
    public static int DOTS_TO_WIN = 1;

    // Настройка обозначений...
    public static final char DOT_EMPTY = '*';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    // Состояние игрового поля...
    public static char[][] map;

    // Экземпяр класса для считывания данных из входного потока данных...
    public static Scanner sc = new Scanner(System.in);

    // Экземпляр класса рандомайзера...
    public static Random rand = new Random();

    public static void main(String[] args) {
        getConfigs();

        clearSreen();
        initMap();
        printMap();

        while (true) {
            humanTurn();
            clearSreen();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Вы победили!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья!");
                break;
            }

            aiTurn();
            clearSreen();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Побели PC!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
        }

        System.out.println("Игра окончена!");
    }

    // Первичная настройка...
    public static void getConfigs() {
        while (true) {
            System.out.println("Введите размерность поля и условия победы SIZE DOTS_TO_WIN:");

            SIZE = sc.nextInt();
            DOTS_TO_WIN = sc.nextInt();

            if (SIZE < 3) {
                System.out.println("Размер поля не может быть меньше 3");
                continue;
            }

            if (DOTS_TO_WIN < 2) {
                System.out.println("Победная комбинация не может быть меньше 2");
                continue;
            }

            if (DOTS_TO_WIN > SIZE) {
                System.out.println("Некорректные данные: длина комбинации не должна превышать размер поля");
                continue;
            }

            break;
        };
    }

    // Проверка диагонали на победную комбинацию...
    public static boolean checkDiagonal(char symb, int x, int y) {
        boolean upCombo = true;
        boolean downCombo = true;

        for (int i=0; i<DOTS_TO_WIN; i++) {

            // Побитова "И" для сокращения кода.
            // Если серия из 1, то имеем победную комбинацию...
            upCombo &= (map[i+x][i+y] == symb);
            downCombo &= (map[DOTS_TO_WIN-i-1+x][i+y] == symb);
        }

        return upCombo || downCombo;
    }

    // Проверка горизонтали/вертикали на победную комбинацию...
    public static boolean checkVerticalHorizontal(char symb, int x, int y) {
        boolean isWin = false;
        boolean vertical, horizontal;

        for (int i=x; i<(DOTS_TO_WIN + x); i++) {
            vertical = true;
            horizontal = true;

            for (int j=y; j<(DOTS_TO_WIN + y); j++) {

                // Побитова "И" для сокращения кода.
                // Если серия из 1, то имеем победную комбинацию...
                horizontal &= (map[j][i] == symb);
                vertical &= (map[i][j] == symb);
            }

            if (vertical || horizontal)
                isWin = true;
            break;
        }

        return isWin;
    }

    // Проверка: имеется ли победная комбинация по символу...
    public static boolean checkWin(char symb) {
        for (int x=0; x<(SIZE-DOTS_TO_WIN+1); x++) {
            for (int y=0; y<(SIZE-DOTS_TO_WIN+1); y++) {

                // Вызываем методы проверки и если хоть один блок заполнен,
                // то игрок, который проставляет это символ - выиграл,
                // иначе, продолжаем для другого смещения
                if (checkDiagonal(symb, x, y) || checkVerticalHorizontal(symb, x, y)) return true;
            }
        }

        // Если нет победных подполей => продолжаем...
        return false;
    }

    // Проверка: есть ли ходы на карте...
    public static boolean isMapFull() {
        boolean has_empty_cell = true;

        outer: for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    has_empty_cell = false;

                    // Прерывание внешнего цикла...
                    break outer;
                };
            }
        }

        return has_empty_cell;
    }

    // Процедура хода PC...
    public static void aiTurn() {
        int x, y;

        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));

        System.out.println("Компьютер сделал ход " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    // Процедура хода человека...
    public static void humanTurn() {
        int x, y;

        do {
            System.out.println("Введите координаты в формате \"X Y\":");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    // Валидация входных координат...
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        if (map[y][x] == DOT_EMPTY) return true;
        return false;
    }

    // Первичная настройка поля...
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    // Напечатать поле в консоли...
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) {
                System.out.print(i + "     ");
            } else{
                System.out.print(i + " ");
            }
        }

        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "     ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Очистка экрана...
    public static void clearSreen() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

}