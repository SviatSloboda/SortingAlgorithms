import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(100000);
        }
        System.out.println(Arrays.toString(QuickSort.quickSort(arr)));
    }
}


    //bucketSort
    //shellSort
    //Heap Sort





