// 3. Реализовать простой калькулятор
import java.util.Scanner;

public class task3 {
    static String[] operators = new String[] { "-", "+", "/", "*", "x", "^" };

    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите выражение (выход - quit): ");
        String equation = iScanner.next();
        while (!equation.equals("quit")) {
            String result = resultOfEquation(equation);
            System.out.printf("%s = %s\n", equation, result);
            System.out.printf("Введите выражение (выход - quit): ");
            equation = iScanner.next();
        }
        iScanner.close();
    }

    public static String findOperator(String equation) {
        for (String operator : operators) {
            if (equation.contains(operator))
                return operator;

        }
        System.out.println("Введено неверное выражение!");
        return "Неправильный ввод";
    }

    public static String resultOfEquation(String equation) {
        String operator = findOperator(equation);
        String[] eq_arr = equation.split("\\" + operator);
        int left = Integer.parseInt(eq_arr[0]);
        int right = Integer.parseInt(eq_arr[1]);
        String result = "";

        switch (operator) {
            case "+":
                result = Double.toString(left + right);
                break;
            case "-":
                result = Double.toString(left - right);
                break;
            case "*":
                result = Double.toString(left * right);
                break;
            case "/":
                result = Double.toString(left / right);
                break;
            case "^":
                result = Double.toString(Math.pow(left, right));
                break;
        }
        return result;
    }
}
