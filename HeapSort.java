import java.util.ArrayList;
import java.util.Random;

public class HeapSort {
    public static void main(String[] args) {
        ArrayList<Integer> aList = getArray(12);
        System.out.println(aList);
        sortArray(aList);
        System.out.println(aList);
    }

    static ArrayList<Integer> getArray(int size) {
        ArrayList<Integer> aList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            aList.add(rnd.nextInt(size));
        }
        return aList;
    }

    static void sortArray(ArrayList<Integer> list) {
        int size = list.size();
        for (int i = size / 2; i >= 0; i--) {
            heap(i, size, list);
        }

        for (int j = size - 1; j > 0; j--) {
            int temp = list.get(0);
            list.set(0, list.get(j));
            list.set(j, temp);
            heap(0, j, list);
        }
        //

    }

    private static void heap(Integer i, int n, ArrayList<Integer> list) {
        int large = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && list.get(left) >= list.get(large)) {

            // int temp = list.get(large);
            // list.set(large, list.get(left));
            // list.set(left, temp);
            large = left;

        }
        if (right < n && list.get(right) >= list.get(large)) {

            // int temp = list.get(large);
            // list.set(large, list.get(right));
            // list.set(right, temp);
            large = right;
        }
        if (large != i) {
            int temp = list.get(i);
            list.set(i, list.get(large));
            list.set(large, temp);
            System.out.printf("%d -> %d\n", list.get(i), list.get(large));
            heap(large, n, list);
        }

    }
}
