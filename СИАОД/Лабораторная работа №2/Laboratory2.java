package SecondLab;

import java.util.Random;
import java.util.Scanner;

public class Laboratory2 {

    static int[] array;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Введите количество элементов: ");
        int m = in.nextInt();

        array = new int[m];
        generateMass(m);
        //System.out.println("Бинарное дерево: ");
        //insertTree();
        bubbleSort();
        outputMass();
        //System.out.println("Бинарный поиск: ");
        //int binary = BinarySearch(5, 0, array.length-1);
        //System.out.println(binary);

        //System.out.println("Интерполяционный поиск: ");
        //int index = interpolationSearch(5, 0, array.length-1);
        //System.out.println(index);

        //System.out.println("Бинарный поиск (Стандартная функция Java): ");
        //System.out.println(Arrays.binarySearch(array, 5));
    }

    public static void insertTree(){
        Tree tree = new Tree();
        for (int i = 0; i< array.length; i++){
            tree.insertNode(array[i]);
        }
        Node foundNode = tree.findNodeByValue(5);
        foundNode.printNode();
        tree.printTree();
        tree.deleteNode(5);
        tree.printTree();
    }

    public static void generateMass(int m){
        int MIN_LIMIT = -10;
        int MAX_LIMIT = 10;
        Random random = new Random();
        for (int i=0; i<m; i++){
            array[i] = (int) (Math.random() * ((MAX_LIMIT - MIN_LIMIT) + 1)) + MIN_LIMIT ;
        }
    }
    
    public static void outputMass(){
        for (int i = 0; i< array.length; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
    public static void bubbleSort() {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    sorted = false;
                }
            }
        }
    }

    public static int BinarySearch(int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < key) {
                low = mid + 1;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else if (array[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public static int interpolationSearch(int elementToSearch, int startIndex, int lastIndex) {

        while ((startIndex <= lastIndex) && (elementToSearch >= array[startIndex]) &&
                (elementToSearch <= array[lastIndex])) {
            // используем формулу интерполяции для поиска возможной лучшей позиции для существующего элемента
            int pos = startIndex + (((lastIndex-startIndex) /
                    (array[lastIndex]-array[startIndex]))*
                    (elementToSearch - array[startIndex]));

            if (array[pos] == elementToSearch)
                return pos;

            if (array[pos] < elementToSearch)
                startIndex = pos + 1;

            else
                lastIndex = pos - 1;
        }
        return -1;
    }
}
