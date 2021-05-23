package Koursovaya;

import java.util.Arrays;
import java.util.Scanner;

public class MaxTriangle {

    static void maxPerimeter(int arr[], int n) {

        arr = arrRevSort(arr); // сортируем элементы массива в обратном порядке


        int maxPerimeter = 0;

        int maxA = 0;
        int maxB = 0;
        int maxC = 0;



        // запускаем цикл через отсортированный массив и проверяем, образует ли он треугольник или нет.

        for (int i = 0; i < n - 2; i++) {
            if ((arr[i] < arr[i + 1] + arr[i + 2]) && (maxPerimeter< arr[i] + arr[i + 1] + arr[i + 2])) {
                // если он образует треугольник это треугольник с максимальный периметр.
                maxPerimeter = arr[i] + arr[i + 1] + arr[i + 2];
                maxC = arr[i];
                maxB = arr[i + 1];
                maxA = arr[i + 2];
                break;
            }
        }



        // Если максимальный периметр ненулевой: распечатать его.
        if (maxPerimeter > 0) {
            System.out.println("Максимальный периметр: " + maxPerimeter);
            System.out.println("Со сторонами треугольника: " + maxA + ", " + maxB + ", " + maxC);
        } // иначе треугольник не образуется
        else {
            System.out.println("Формирование треугольника невозможно.");
        }

    }

    // Функция возвращает отсортированный массив по убыванию

    static int[] arrRevSort(int[] arr) {
        Arrays.sort(arr, 0, arr.length);
        int j = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество отрезков: ");
        int n;
        do {
            n = in.nextInt();
        }while (n <= 2);

        int[] arr = new int[n];
        System.out.println("Введите отрезки: ");
        for (int i = 0; i < n; i++){
            do {
                arr[i] = in.nextInt();
            }while (arr[i] < 1);
        }
        maxPerimeter(arr, n);
    }

}
