
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class twoDec {

    public static void main(String[] args) throws IOException {
        System.out.println("Задание №1:");
        System.out.println(firstTask("C:\\TestLab4\\Task1.txt"));

        System.out.println();
        System.out.println("Задание №2:");
        System.out.println(secondTask("helloworld","C:\\TestLab4\\Task2.txt", true));

        System.out.println();
        System.out.println("Задание №3:");
        System.out.println(ThirdTask(3, 1, 2, 3, true));

        System.out.println();
        System.out.println("Задание №4:");
        System.out.println(fourthTask("C:\\TestLab4\\Task4.txt", '{', '}'));

        System.out.println();
        System.out.println("Задание №5:");
        System.out.println(fifthTask("C:\\TestLab4\\Task5.txt", '[', ']'));

        System.out.println();
        System.out.println("Задание №6:");
        System.out.println(sixTask("C:\\TestLab4\\Task6.txt"));

        System.out.println();
        System.out.println("Задание №7:");
        System.out.println(sevenTask("C:\\TestLab4\\Task7.txt"));

        System.out.println();
        System.out.println("Задание №8:");
        System.out.println(eightTask("C:\\TestLab4\\Task8.txt"));

        System.out.println();
        System.out.println("Задание №9:");
        System.out.println(nineTask("C:\\TestLab4\\Task9.txt"));

        System.out.println();
        System.out.println("Задание №10:");
        tenTask("C:\\TestLab4\\Task10.txt");
    }

    /*
        Task 1
    */

    public static Deque<String> firstTask(String file) throws IOException {
        Scanner sc = new Scanner(new File(file));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);

        int n = arr.length;
//        for (int i = 0; i<arr.length;i++){
//            System.out.println(arr[i]);
//        }

        Deque<String> BooksDeque = new ArrayDeque<>();

        if (n < 1){
            return BooksDeque;
        } else if(n == 1){
            BooksDeque.addFirst(arr[0]);
            return BooksDeque;
        }
        Deque<String> SortedDeque = new ArrayDeque<>();

        BooksDeque.addFirst(arr[0]);

        for (int i = 1; i < n; i++){
            while ((BooksDeque.size() > 0) && isEquals(BooksDeque.getFirst().toLowerCase(), arr[i].toLowerCase()))
            {
                SortedDeque.addLast(BooksDeque.removeFirst());
            }
            BooksDeque.addFirst(arr[i]);
            while (!SortedDeque.isEmpty())
            {
                BooksDeque.addFirst(SortedDeque.removeLast());
            }
        }

        return BooksDeque;
    }

    static Boolean isEquals(String book, String book2){
        for (int i = 0; i < Math.min(book2.length(), book.length()); i++)
        {
            if (book.charAt(i) != book2.charAt(i))
            {
                return book.charAt(i) <= book2.charAt(i); //book2 раньше
            }
        }
        return book.length() <= book2.length();
    }


    /*
        Task 2
    */

    public static String secondTask(String str, String file, Boolean encrypt) throws FileNotFoundException {

        char[] arr = readCharFromFile(file);

        int n = arr.length;

        Deque<Character> parens = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++)
        {
            parens.addFirst(arr[i]);
        }
        if (encrypt)
            return encryption(parens, str);
        else
            return decryption(parens, str);
    }

    public static String encryption(Deque<Character> deque, String str){   // Шифрование
        String  enc = "";
        for (int i = 0; i < str.length(); i++)
        {
            enc += getSymbol(deque, str.charAt(i), -1);
        }
        return enc;
    }

    static char getSymbol(Deque<Character> deque, char a, int i) {
        while (deque.getFirst() != a)
        {
            deque = Spin(deque, 1);
        }
        deque = Spin(deque, i);
        return deque.getFirst();
    }

    public static Deque<Character> Spin(Deque<Character> deque, int spinCount){
        if (spinCount == 1){
            deque.offerLast(deque.removeFirst());
        }else {
            deque.offerFirst(deque.removeLast());
        }
        return deque;
    }

    public static String decryption(Deque<Character> deque, String str){  // Расшифровка
        String dec = "";
        for (int i = 0; i < str.length(); i++)
        {
            dec += getSymbol(deque, str.charAt(i), 1);
        }
        return dec;
    }

    public static char[] readCharFromFile(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        String word = "";
        while (sc.hasNextLine()) {
            word = sc.next();
        }
        char[] DeqMass = new char[word.length()];
        for (int i = 0; i<word.length(); i++){
            DeqMass[i] = word.charAt(i);
        }
        return DeqMass;
    }

    /*
        Task 3
    */

    public static String ThirdTask(int count, int a, int b, int c, boolean flag){
        if (flag && count == 2)
        {
            count--;
            return ThirdTask(count, a, c, b, false) + "\n" + a + " - " + c + "\n" + ThirdTask(count, b, a, c, false);
        }
        if (count > 3)
        {
            count--;
            return ThirdTask(count, a, c, b, false) + "\n" + a + " - " + c + "\n" + ThirdTask(count, b, a, c, false);
        }
        else
        {
            switch (count)
            {
                case 1:
                    return a + " - " + c;
                case 2:
                    count--;
                    return ThirdTask(count, a, b, c, false) + "\n" + a + " - " + b + "\n" + ThirdTask(count, c, a, b, false);
                case 3:
                    count--;
                    return ThirdTask(count, a, b, c, false) + "\n" + a + " - " + c + "\n" + ThirdTask(count, b, c, a, false);
                default:
                    return "";
            }
        }
    }
//    public static void ThirdTask() throws IOException {
//
//        Stack<Integer> stackLeft = new Stack<>();
//        Stack<Integer> stackMiddle = new Stack<>();
//        Stack<Integer> stackRight = new Stack<>();
//
//        for (int i = 5; i>0; i--){
//            stackLeft.push(i);
//        }
//
//        moveTower(3, stackLeft, stackMiddle, stackRight);
//
//    }

//    public static void moveTower(int discCount, Stack first, Stack second, Stack third){
//        if(discCount == 0){
//            System.out.println(third);
//            return;
//        }
//        moveTower(discCount - 1, first, third, second);
//
//        second = moveAdd(first, second);
//        first = moveDel(first, second);
//
//        moveTower(discCount - 1, third, second, first);
//    }

//    private static Stack moveAdd(Stack first, Stack second){
//        second.push(first.peek());
//        return second;
//    }

//    private static Stack moveDel(Stack first, Stack second){
//        first.pop();
//        return first;
//    }


    /*
        Task 4
    */

    public static boolean fourthTask(String file, char start, char end) throws FileNotFoundException {
        String arr = "";
        Scanner in = new Scanner(new File(file));
        while(in.hasNext())
            arr += in.nextLine() + "\r\n";
        in.close();

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0;i<arr.length(); i++)
        {
            if (arr.charAt(i) == start)
            {
                stack.push('+');
            }
            if(arr.charAt(i) == end)
            {
                try
                {
                    stack.pop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return stack.isEmpty();
    }

    /*
        Task 5
    */

    public static boolean fifthTask(String file, char start, char end) throws FileNotFoundException {
        String arr = "";
        Scanner in = new Scanner(new File(file));
        while(in.hasNext())
            arr += in.nextLine() + "\r\n";
        in.close();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0;i<arr.length(); i++)
        {
            if (arr.charAt(i) == start)
            {
                deque.push('+');
            }
            if(arr.charAt(i) == end)
            {
                try
                {
                    deque.pop();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return deque.isEmpty();
    }

    /*
        Task 6
    */

    public static String sixTask(String file) throws FileNotFoundException {
        String arr = "";
        Scanner in = new Scanner(new File(file));
        while(in.hasNext())
            arr += in.nextLine() + "\r\n";
        in.close();


        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i< arr.length(); i++)
        {
            if (arr.charAt(i)>=48 && arr.charAt(i)<=57)  // 0 до 10
            {
                sb.append(arr.charAt(i));
            }
            else
            {
                if ((arr.charAt(i) >= 65 && arr.charAt(i) <= 90) || (arr.charAt(i) >= 97 && arr.charAt(i) <= 122))  // Буквы
                {
                    stack.push(arr.charAt(i));
                }
                else
                {
                    stack2.push(arr.charAt(i));
                }
            }
        }
        int count = sb.length();
        while (!stack.isEmpty())
        {
            sb.insert(count, stack.pop());
        }
        count = sb.length();
        while (!stack2.isEmpty())
        {
            sb.insert(count, stack2.pop());
        }
        return sb.toString();
    }

    /*
        Task 7
    */

    public static String sevenTask(String file) throws FileNotFoundException {

        String arr = "";
        Scanner in = new Scanner(new File(file));
        while(in.hasNext())
            arr += in.nextLine();
        in.close();

        int count = 0;
        String[] s = arr.split(" ");
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new ArrayDeque<>();
        for (String value : s) {
            int a = Integer.parseInt(value);
            if (a >= 0) {
                deque.addLast(a);
            } else {
                deque.addFirst(a);
                count++;
            }
        }
        for(int i = 0; i<count; i++)
        {
            sb.insert(0, deque.removeFirst() + " ");
        }
        while (!deque.isEmpty())
        {
            sb.append(deque.removeFirst()).append(" ");
        }
        return sb.toString().trim();
    }

    /*
        Task 8
    */

    public static String eightTask(String file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file));
        List<String> lines = new ArrayList<>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }

        String[] arr = lines.toArray(new String[0]);

        Stack<String> stack = new Stack<>();

        for(String i: arr){
            stack.push(i);
        }
        String result = "";
        while (!stack.isEmpty()){
            result +=stack.pop() + "\n";
        }
        return result;
    }

    /*
        Task 9
    */

    public static boolean nineTask(String file) throws FileNotFoundException {

        String formula = "";
        Scanner in = new Scanner(new File(file));
        while (in.hasNext())
            formula += in.nextLine();
        in.close();

        Stack<Integer> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        String str = "AXO";
        boolean lv = false;                      // Инициализация логического выражения
        int k = formula.indexOf("=");
        if (formula.charAt(k + 2) == 'T')
            lv = true;
        formula = formula.substring(k + 3);  // удаляем часть с инициализацией
        int m = formula.indexOf("<");
        while (m != -1) {
            int f = formula.indexOf(">");
            if (str.indexOf(formula.charAt(f + 1)) != -1 && formula.charAt(m - 1) == 'N' && formula.charAt(f + 2) == 'N') {
                stack1.push(4);
                stack2.push(formula.charAt(f + 1));
            }else if (str.indexOf(formula.charAt(f + 1)) != -1 && formula.charAt(m - 1) == 'N') {
                stack1.push(3);
                stack2.push(formula.charAt(f + 1));
            }else if (str.indexOf(formula.charAt(f + 1)) != -1) {
                stack1.push(2);
                stack2.push(formula.charAt(f + 1));
            }else if (formula.charAt(m - 1) == 'N') {
                stack1.push(1);
                stack2.push('N');
            }

            formula = formula.substring(f + 1);
            m = formula.indexOf("<");
        }
        while (!stack1.isEmpty()) {
            if (stack1.peek() == 1) {
                if (checkFirst(lv)) {
                    return true;
                }
            } else if (stack1.peek() == 2) {
                if (checkSecond(stack2.peek(), lv)) {
                    return true;
                }
            } else if (stack1.peek() == 3) {
                if (checkThird(stack2.peek(), lv)) {
                    return true;
                }
            }else{
                if (checkFour(stack2.peek(), lv)) {
                    return true;
                }
            }
            stack1.pop();
            stack2.pop();
            return false;
        }
        return true;
    }
    public static Boolean checkFirst ( boolean lv){
        return !lv;
    }
    public static Boolean checkSecond ( char str1, boolean lv){
        return switch (str1) {
            case 'A', 'O' -> lv;
            default -> false;         // XOR
        };
    }
    public static Boolean checkThird ( char str1, boolean lv){
        return switch (str1) {
            case 'X', 'O' -> true;
            default -> false;       // AND
        };
    }
    public static Boolean checkFour ( char str1, boolean lv){
        if (str1 == 'O' || str1 == 'A')
            return !lv;

        return false; // xor
    }


    public static void tenTask(String file) throws FileNotFoundException{
        String str = "";
        Scanner in = new Scanner(new File(file));
        while (in.hasNext())
            str += in.nextLine();
        in.close();

        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();
        Stack<Integer> minMax = new Stack<>();

        int f = str.indexOf("(");
        while (f != -1) {
            int l = str.indexOf(")");
            if (str.charAt(f-1) == 'M'){
                minMax.push(0);
            }else if(str.charAt(f-1) == 'N'){
                minMax.push(1);
            }
            a.push((int) str.charAt(f+1));
            b.push((int) str.charAt(l-1));
            str = str.substring(l+1);
            f = str.indexOf("(");
        }

        while (!a.isEmpty()){
            if (minMax.peek() == 0) {
                findMax(a.pop(), b.pop());
            }else{
                findMin(a.pop(), b.pop());
            }
            minMax.pop();
        }
    }

    public static void findMin(int a, int b){
        if (a < b)
            System.out.println("Минимум: " + (char) a);
        else
            System.out.println("Минимум: " + (char) b);
    }

    public static void findMax(int a, int b){
        if (a > b) {
            System.out.println("Максимум: " + (char) a);
        }
        else
            System.out.println("Максимум: " + (char) b);
    }

    /*
        Task 10
    */
    public static void elevenTask(String file) throws FileNotFoundException{
        String str = "";                           // Читаем строку из файла
        Scanner in = new Scanner(new File(file));
        while (in.hasNext())
            str += in.nextLine();
        in.close();


    }
}
