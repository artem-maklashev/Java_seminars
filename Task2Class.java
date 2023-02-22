import java.util.LinkedList;

public class Task2Class {    
    private LinkedList<Integer> list = new LinkedList<>();
    
    LinkedList<Integer> getLinkedList(int size) {        
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    void enqueue(int number) {
        list.addLast(number);
    }

    int dequeue() {
        int firstElement = list.pop();
        return firstElement;
    }

    int first() {
        return list.getFirst();
    }

    void print() {
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
