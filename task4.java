// 4.*+Задано уравнение вида q+w=e,q,w,e>=0. Некоторые цифры могут быть заменены знаком вопроса,например 2?+?5=69. 
// Требуется восстановить выражение до верного равенства.Предложить хотя бы одно решение или сообщить,что его нет
import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите выражение (выход - quit): ");
        String equation = iScanner.next();
        while (!equation.equals("quit")) {
            String result = resultOfEquation(equation);
            System.out.printf("%s -> %s\n", equation, result);
            System.out.printf("Введите выражение (выход - quit): ");
            equation = iScanner.next();            
        }
        iScanner.close();
    }

    public static String resultOfEquation(String equation) {
        String result_equiation = "";
        String[] equation_parts = equation.split("=");
        String result = equation_parts[1];
        String[] left_part = equation_parts[0].split("\\"+"+");
        String left = left_part[0];
        String right = left_part[1];
        result_equiation = findResult(left, right, result)+'='+result;
        return result_equiation;
    }

    public static String findResult(String left, String right, String result) {
        int left_index = left.indexOf("?");
        int right_index = right.indexOf("?");
        int left_number = 0;
        int right_number = 0;
        if (left_index > right_index) {
            left_number = (result.charAt(left_index)-'0') - (right.charAt(left_index)-'0');
            if (left_number < 0) {
                left_number += 10;
                right_number = (result.charAt(right_index)-'0')
                        - (left.charAt(right_index)-'0') - 1;
            } else {
                right_number = (result.charAt(right_index)-'0')
                        - (left.charAt(right_index)-'0');
            }
        } else {
            right_number = (result.charAt(right_index) - '0')
                    - (left.charAt(right_index) - '0');
            if (right_number < 0) {
                right_number += 10;
                left_number = (result.charAt(left_index) - '0')
                        - (right.charAt(left_index) - '0') - 1;
            } else {
                left_number = (result.charAt(left_index) - '0')
                        - (left.charAt(left_index) - '0');
            }
        }
        // System.out.printf("left %d, right %d", left_number, right_number);
        if ((left_number >= 0) && (right_number >= 0)) {
            left = left.replace('?', (char) (left_number+'0'));
            right = right.replace('?', (char) (right_number + '0'));
            return left + '+' + right;
        }
        return "Решения нет";
    }
}
