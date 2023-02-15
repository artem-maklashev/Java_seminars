import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
// 2 . Реализуйте алгоритм сортировки пузырьком числового массива,
//     результат после каждой итерации запишите в лог-файл.
public class task2 {    
    public static void main(String[] args) throws IOException{
        Logger logger = Logger.getLogger(task2.class.getName());
        FileHandler fh = new FileHandler("task2log.txt");
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.addHandler(fh);

        int[] arr = { -5, 23, 7, 5, 3, -12, -29, 21, 54, 35, 0 };
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        logger.log(Level.INFO, Arrays.toString(arr), StandardCharsets.UTF_8);
        }
    }
}
