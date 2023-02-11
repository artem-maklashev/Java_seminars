// 4.*+Задано уравнение вида q+w=e,q,w,e>=0. Некоторые цифры могут быть заменены знаком вопроса,например 2?+?5=69. 
// Требуется восстановить выражение до верного равенства.Предложить хотя бы одно решение или сообщить,что его нет
import java.util.Scanner;

public class task4_new {
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
    
    static String resultOfEquation(String equation) {        
        String[] firstSplit = equation.split("=");
        String equationResult = firstSplit[1];
        String[] secondSplit = firstSplit[0].split("\\"+"+");
        String left = secondSplit[0];
        String right = secondSplit[1];
        String leftNew = "";
        String rightNew = "";
        String equationResultNew = "";
        for (int i = 0; i < 10; i++) {                      
            for (int j = 0; j < 10; j++) {                
                for (int k = 0; k < 10; k++) {
                    equationResultNew = equationResult.replace('?', (char) (k + '0'));
                    leftNew = left.replace('?', (char) (i + '0'));
                    rightNew = right.replace('?', (char) (j+'0'));                    
                    if (Integer.parseInt(leftNew) + Integer.parseInt(rightNew) == Integer.parseInt(equationResultNew)) {
                        return leftNew + '+' + rightNew + '=' + equationResultNew;
                    }
                }
            }
        }
        return "Решения нет";
    }
}
