package Koursovaya;

import java.util.Scanner;

public class StringThird {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Введите строку:");
        String str1 = s.nextLine();//получаем строку
        ex3(str1);
    }
    public static void ex3(String str1){
        int count = 0;
        for (int i=0; i<str1.length();i++){//определяем начало поиска
            String sub = "";
            for(int j=i; j<str1.length();j++){//добавляем
                sub+=str1.charAt(j);
                if (str1.indexOf(sub,j) == i+sub.length()){//если ближайшее вхождение текущего слова находится
                    count++;//сразу после его конца, то увеличиваем счетчик искомых слов
                    if (str1.indexOf(sub,j + sub.length()) >= 0){
                        count --;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
