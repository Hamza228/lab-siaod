package Koursovaya;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class maxNumber {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество чисел: ");
        int n = in.nextInt();

        int[] arr = new int[n];
        System.out.println("Введите числа: ");
        for (int i = 0; i < n; i++){
            do {
                arr[i] = in.nextInt();
            }while (arr[i] < 0);
        }
        System.out.println("Максимальное число: " + maxNum(arr));
    }

    public static String maxNum(int[] arr) {
        String str = "";
        List<Integer> list = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        list.sort((a, b) -> measure(b) - measure(a));
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        return str;
    }

    public static int measure(int n) {
        if (n < 10) { return 100*n + 10*n + n; }
        else if (n < 100) { return 10*n + n%10; }
        else if (n < 1000) { return n; }
        else { return -1; }
    }
}
