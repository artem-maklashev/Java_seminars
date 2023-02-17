import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Реализовать алгоритм сортировки слиянием
 */
public class task1 {
    public static void main(String[] args) {
        Scanner iscanner = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int number = iscanner.nextInt();
        iscanner.close();
        int[] baseArray = getArray(number);
        task1 ob = new task1();        
        ob.mergeSort(0, number-1, baseArray);
        System.out.println(Arrays.toString(baseArray));       

    }
    
    static int[] getArray(int number) {
        int[] tempArray = new int[number];
        Random random = new Random();
        for (int i = 0; i < tempArray.length; i++) {
            int numb = random.nextInt(100);
            tempArray[i] = numb;
        }
        System.out.println(Arrays.toString(tempArray));
        return tempArray;
    }

    void mergeSort(int startIndex, int finishIndex, int[] baseArray) {
        if (startIndex < finishIndex) {
            int middleIndex = startIndex + (finishIndex-startIndex) / 2;
            mergeSort(startIndex, middleIndex, baseArray);
            mergeSort(middleIndex + 1, finishIndex, baseArray);
            mergeParts(startIndex, middleIndex, finishIndex, baseArray);
        }
    }
    
    void mergeParts(int startIndex, int middleIndex, int finishIndex, int[] baseArray) {
        int leftLengh = middleIndex + 1 - startIndex;
        int rightLength = finishIndex - middleIndex;
        int[] leftPart = new int[leftLengh];
        int[] rightPart = new int[rightLength];

        for (int i = 0; i < leftLengh; i++) {
            leftPart[i] = baseArray[startIndex + i];
        }
        for (int j = 0; j < rightLength; j++) {
            rightPart[j] = baseArray[middleIndex + 1 + j];
        }
        System.out.printf("Лево %s, право %s\n", Arrays.toString(leftPart), Arrays.toString(rightPart));
        int i = 0, j = 0;
        int k = startIndex;
        while (i < leftLengh && j < rightLength) {
            if (leftPart[i] <= rightPart[j]) {
                baseArray[k] = leftPart[i];
                i++;                
            }
            else {
                baseArray[k] = rightPart[j];
                j++;
            }
            k++;
        }
        while (i < leftLengh) {
            baseArray[k] = leftPart[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            baseArray[k] = rightPart[j];
            j++;
            k++;
        }
        // System.out.println(Arrays.toString(baseArray));
    }    
}