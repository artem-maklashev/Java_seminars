import java.util.LinkedList;
import java.util.Scanner;

/**
 * Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который
 * вернет “перевернутый” список. Постараться не обращаться к листу по индексам.
 */
public class task1 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        int size = Integer.parseInt(iScanner.next());
        iScanner.close();
        LinkedList<Integer> myList = getLinkedList(size);
        System.out.println(myList);
        LinkedList<Integer> reverceList = reverceLinkedList(myList);
        System.out.println(reverceList);
    }
    
    static LinkedList<Integer> getLinkedList(int size) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    static LinkedList<Integer> reverceLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> reverceList = new LinkedList<>();
        while(list.size()>0) {
            reverceList.addLast(list.removeLast());
        }
        return reverceList;
    }
    
}