package SecondLab;

import java.util.Scanner;

public class Ferzi {

    private static int[][] board;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размеры Шахматной доски(n*n) : ");
        int n = in.nextInt();
        board = new int[n][n];
        initializeBoard(n);        // Инициализируем доску, заполняя нулями
        findSolution(n);
    }

    public static void findSolution(int n){
        int counter = 0;
        while (counter != 8){
            for (int i = 0; i<n; i++){
                if(isAtack(board[counter][i], counter)){

                }

            }
            counter++;
        }
    }

    public static boolean isAtack(int m, int k){
        //if(board)
        return true;
    }

    public static void initializeBoard(int n){
        for(int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                board[i][j] = 0;
            }
        }
    }

}
