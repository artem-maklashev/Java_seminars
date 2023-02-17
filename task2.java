// Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner iscanner = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int number = iscanner.nextInt();
        iscanner.close();
        List<Integer> baseList = getList(number);
        deleteEven(baseList);
        System.out.println(baseList);
    }
    
    static List<Integer> getList(int number) {
        List<Integer> tempList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int numb = random.nextInt(100);
            tempList.add(numb);
        }
        System.out.println(tempList);
        return tempList;
    }

    static void deleteEven(List<Integer> list){
        list.removeIf(n -> (n % 2 == 0));
    }

}
