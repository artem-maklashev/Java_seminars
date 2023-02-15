import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 4*. К калькулятору из предыдущего дз добавить логирование.
 */
public class task4 {
  static String[] operators = new String[] { "-", "+", "/", "*", "x", "^" };
  static Charset charset = StandardCharsets.UTF_8;
  private static Logger logger = Logger.getLogger(task4.class.getName());
  public static void main(String[] args) throws SecurityException, IOException {
    // Logger logger = Logger.getLogger(task4.class.getName());
    FileHandler fh = new FileHandler("task4log.txt", false);
    SimpleFormatter sFormat = new SimpleFormatter();
    fh.setFormatter(sFormat);
    logger.addHandler(fh);
    
    Scanner iScanner = new Scanner(System.in);
    System.out.printf("Введите выражение (выход - quit): ");
    String equation = iScanner.next();
    logger.log(Level.INFO, "Input equation: "+equation, charset);
    while (!equation.equals("quit")) {
      String result = resultOfEquation(equation);
      logger.log(Level.INFO, "Result="+result, charset);
      System.out.printf("%s = %s\n", equation, result);
      System.out.printf("Введите выражение (выход - quit): ");
      equation = iScanner.next();
      logger.log(Level.INFO, "Input equation: "+equation, charset);
    }
    iScanner.close();
  }

  public static String findOperator(String equation) {
    for (String operator : operators) {
      if (equation.contains(operator)) return operator;
    }
    // logger.log(Level.WARNING, "Введено неверное выражение!");
    System.out.println("Введено неверное выражение!");
    logger.log(Level.WARNING, "Input wrong equation!");
    return "Неправильный ввод";
  }

  public static String resultOfEquation(String equation) {
    String operator = findOperator(equation);
    String[] eq_arr = equation.split("\\" + operator);
    String result = "";
    if (eq_arr.length > 1) {
      int left = Integer.parseInt(eq_arr[0]);
      int right = Integer.parseInt(eq_arr[1]);
      logger.info("operator "+operator);
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
    }
    return result;  
  }
}
