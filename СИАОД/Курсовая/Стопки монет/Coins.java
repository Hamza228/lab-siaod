package Koursovaya;

import java.util.ArrayList;
import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество стопок: ");
        int n;
        do {
            n = in.nextInt();
        }while (n % 3 != 0);

        int[] arr = new int[n];
        System.out.println("Введите числа: ");
        for (int i = 0; i < n; i++){
            do {
                arr[i] = in.nextInt();
            }while (arr[i] < 1);
        }
        System.out.println("Максимум: " + maxCoins(arr, n));
    }
    public static int maxCoins(int[] arr, int n){
        ArrayList<Integer> list = new ArrayList();
        int max = 0;

        for (int i = 0; i < n; i++){
            list.add(arr[i]);
        }
        while (!list.isEmpty()){
            int maxArr = list.get(0);
            int indexArr = 0;
            for (int i = 0; i < n; i++){
                if (maxArr < list.get(i)) {
                    maxArr = list.get(i);
                    indexArr = i;
                }
            }
            n--;
            list.remove(indexArr);
            maxArr = list.get(0);
            indexArr = 0;
            for (int i = 0; i < n; i++){
                if (maxArr < list.get(i)) {
                    maxArr = list.get(i);
                    indexArr = i;
                }
            }
            n--;
            max +=maxArr;
            list.remove(indexArr);
            maxArr = list.get(0);
            indexArr = 0;
            for (int i = 0; i < n; i++){
                if (maxArr < list.get(i)) {
                    maxArr = list.get(i);
                    indexArr = i;
                }
            }
            n--;
            list.remove(indexArr);
        }
        return max;
    }
}
