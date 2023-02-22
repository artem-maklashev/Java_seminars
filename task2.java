import java.util.Scanner;


public class task2 {
    public static void main(String[] args) {
        Task2Class list = new Task2Class();
        Scanner iScanner = new Scanner(System.in);
        System.out.print("Введите размерность связного списка: ");
        int size = Integer.parseInt(iScanner.next());
        iScanner.close();
        list.getLinkedList(size);
        list.print();    
        System.out.println("Добавляем последний элемент");    
        list.enqueue(size);
        list.print();
        System.out.println("Удаляем первый элемент");
        int fNumber = list.dequeue();
        System.out.println(fNumber);
        list.print();
        System.out.println("Получаем первый элемент не удаляя его");
        int first = list.first();
        System.out.println(first);
        list.print();
    }
}
