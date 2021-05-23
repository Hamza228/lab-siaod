package Koursovaya;

import java.util.Scanner;

public class StringSecond {
    public static void main(String[] args) {
        //запрашиваем входные данные
        Scanner s = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str1 = s.nextLine();
        ex2(str1);
    }

    public static void ex2(String str1) {

        String sub_max = "";//самая длинная подстрока-полиндром
        for (int k=0;k<str1.length();k++) {//определяем с какой позиции начинать
            String sub = "";//текущая подстрока
            for (int i = k; i < str1.length(); i++) {//добавляем следующие буквы в наше слово
                sub += str1.charAt(i);
                if ((sub.equals(Palindrom(sub)))) {//если слово палиндром, то запоминаем его
                    if (sub.length() > sub_max.length())//если слово длиннее текущего палиндрома
                        sub_max = sub;
                }
            }
        }
        System.out.println(sub_max);

        //основная работа

    }
    public static String Palindrom (String s){//проверка на палиндром
        String sub = "";
        for(int i=(s.length()-1);i>=0;i--){
            sub+=s.charAt(i);
        }
        return sub;
    }
}
