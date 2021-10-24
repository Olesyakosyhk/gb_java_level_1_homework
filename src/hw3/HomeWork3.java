/*
1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
2. Задать пустой целочисленный массив длиной 100. С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
5. Написать метод, принимающий на вход два аргумента: len и initialValue, и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue;
6. * Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
7. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны.
**Примеры:
checkBalance([2, 2, 2, 1, 2, 2, ||| 10, 1]) → true, т.е. 2 + 2 + 2 + 1 + 2 + 2 = 10 + 1
checkBalance([1, 1, 1, ||| 2, 1]) → true, т.е. 1 + 1 + 1 = 2 + 1

граница показана символами |||, эти символы в массив не входят и не имеют никакого отношения к ИЛИ.
 */

package hw3;

public class HomeWork3 {

    //1:
    public static void changeZeroOneArray() {
        int[] nums = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = 0;
            } else {
                nums[i] = 1;
            }
        }
    }


    //2:
    public static void oneHundredItemsArray() {
        int[] nums = new int[100];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }
    }


    //3:
    public static void multiplyBy6() {
        int[] nums = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 6) {
                nums[i] = nums[i] * 2;
            }
        }
    }


    //4:
    public static void diagonalMatrix(){
        final int N = 25;   //Размерность

        //Создаем двумерный массиив.
        int[][] matrix = new int [N][N];

        //Обходим основной массив.
        for (int i=0; i< matrix.length; i++) {

            //Обходим вложенный массив.
            for(int j=0; j< matrix.length; j++){

                //Условия для определения является ли элемент диагональю.
                //i==j - главная диагональ.
                //N - i - 1 == j - побочная диагональ
                if (i==j || N - i - 1 == j) {
                    matrix[i][j] = 1;
                }
            }
        }
    }

    //5:
    public static int[] generateArray(int len, int initialValue) {
        int[] nums = new int[len];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = initialValue;
        }

        return nums;
    }


    // 6:
    public static void getMinMax() {
        int[] nums = {3, 3, 9, 3, 1, 3};

        int min = nums[0];
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
    }


    //7:
    public static boolean checkBalance(int[] nums) {
        boolean result = false;

        for (int i = 1; i < nums.length; i++) {

            int leftSum = 0;
            for (int li = 0; li < i; li++) {
                leftSum += nums[li];
            }

            int rightSum = 0;
            for (int ri = i; ri < nums.length; ri++) {
                rightSum += nums[ri];
            }

            if (leftSum == rightSum) {
                result = true;
                break;
            }
        }

        return result;
    }
}