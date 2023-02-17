import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner iscanner = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int number = iscanner.nextInt();
        iscanner.close();
        ArrayList<Integer> baseArrayList = getArrayList(number);
        findData(baseArrayList);
    }

    static ArrayList<Integer> getArrayList(int number) {
        ArrayList<Integer> tempArrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int numb = random.nextInt(100);
            tempArrayList.add(numb);
        }
        System.out.println(tempArrayList);
        return tempArrayList;
    }

    static void findData(ArrayList<Integer> ar) {
        int max = ar.get(0);
        int min = ar.get(0);
        float sum = 0;

        Iterator<Integer> arIterator = ar.iterator();

        while (arIterator.hasNext()) {
            int number = arIterator.next();
            if (number > max)
                max = number;
            if (number < min)
                min = number;
            sum += number;
        }
        float averege = (sum / ar.size());
        System.out.printf("maximum = %d, minimum = %d, averege = %s", max, min, averege);
    }
}
