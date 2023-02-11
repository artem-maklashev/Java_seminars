import java.util.ArrayList;
import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        int number = 0;        
        System.out.println("Введите целое число: ");
        // if (iScanner.hasNextInt()) {
            number = iScanner.nextInt();
        // }
        iScanner.close();
        ArrayList<Integer> result = simpleNumbers(number); 
        System.out.printf("Простые числа в диапазоне от 2 до %d :", number);
        System.out.println(result);

    }
    
    public static boolean isSimpleNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
    
    public static ArrayList<Integer> simpleNumbers(int number) {
        ArrayList<Integer> sNumbers = new ArrayList<Integer>() ;
        for (int j = 2; j <= number; j++) {
            if (isSimpleNumber(j)) {
                sNumbers.add(j);
            }
        }
        return sNumbers;
    }
    
}
