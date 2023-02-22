import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите размерность связного списка: ");
        int size = Integer.parseInt(iScanner.next());
        iScanner.close();
        LinkedList<Integer> myList = getLinkedList(size);
        System.out.println(myList);
        int sum = sum(myList);
        System.out.printf("Сумма всех элементов связного списка равна %d", sum);
    }

    static LinkedList<Integer> getLinkedList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    static int sum(LinkedList<Integer> list) {
        int sum = 0;
        int element = 0;
        Iterator<Integer> listIterator = list.iterator();
        while (listIterator.hasNext()) {
            element = listIterator.next();
            sum += element;
        }
        return sum;
    }
}
