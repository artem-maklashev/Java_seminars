// 1. Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! 
// (произведение чисел от 1 до n

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        int number = 0;        
        System.out.println("Введите целое число: ");
        if (iScanner.hasNextInt()) {
            number = iScanner.nextInt();
        }

        int triNumber = triangleNumber(number);        
        int fact = factorial(number);
        System.out.printf("Треугольное число равно %d, факториал равен %d", triNumber, fact);
        iScanner.close();

    }

    public static int triangleNumber(int n) {
        int result = 0;
        
            result = n* (n + 1) / 2;
        
        return result;
    }
    
    public static int factorial(int number) {
        if (number == 1)
            return 1;
        return number*factorial(number - 1);
    }
}
