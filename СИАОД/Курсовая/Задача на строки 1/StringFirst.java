package Koursovaya;

import java.util.Scanner;

public class StringFirst {
    public static void main(String[] args) {
        //запрашиваем входные данные
        Scanner s = new Scanner(System.in);
        System.out.println("Введите первую строку:");
        String str1 = s.nextLine();//принимаем первую строку
        System.out.println("Введите вторую строку:");
        String str2 = s.nextLine();//принимаем вторую строку
        ex1(str1, str2);
    }

    public static void ex1(String str1, String str2) {

        if (str1.length() != str2.length())
            System.out.println("Строки разной длины");//строки разной длины
        else {
            int count1 = 0;//счестчики цены букв
            int count2 = 0;
            for (int i = 0; i < str1.length(); i++) {//бежим по строкам
                count1 += Method (str1.charAt(i));//суммируем ценность букв
                count2 += Method (str2.charAt(i));
            }
            System.out.println(count2 >= count1);//возвращаем ответ
        }
    }
    public static int Method (char a){//метод сопоставляющий букву из слова и ее ценность
        char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        for (int i=0; i < 28;i++){
            if (a == arr[i]){
                return i;
            }
        }
        return 0;
    }
}
