package Koursovaya;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class matrix {



    static void sortMatrix(int[][] mat, int  m, int n) {

        for(int i = 0; i < m + n - 1; ++i) {
            int startX, startY;
            if(i < n){
                startX = 0;
                startY = n - i - 1;
            }else {
                startX = i - n;
                startY = 0;
            }

            ArrayList<Integer> list = new ArrayList();

            int offset;
            int x;
            int y;
            for(offset = 0; offset >= 0; ++offset) {
                x = startX + offset;
                y = startY + offset;
                if (x >= m || y >= n) {
                    break;
                }

                list.add(mat[x][y]);
            }

            list.sort(Integer::compareTo);

            for(offset = 0; offset >= 0; ++offset) {
                x = startX + offset;
                y = startY + offset;
                if (x >= m || y >= n) {
                    break;
                }

                mat[x][y] = list.remove(0);
            }
        }
    }

    static void printMatrix(int[][] mat, int m, int n) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Введите количество строк: ");
        int m = in.nextInt();
        System.out.println("Введите количество столбцов: ");
        int n = in.nextInt();

        int[][] mat = new int[m][n];
        Random rng = new Random();

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                mat[i][j] =  rng.nextInt(m*n + 1);
            }
        }

        System.out.println("Исходная матрица:");
        printMatrix(mat, m, n);
        sortMatrix(mat, m, n);
        System.out.println("Отсортированная матрица:");
        printMatrix(mat, m, n);
    }
}
