import java.util.Random;

public class QuickSort {
    // O(n * log(n))
    public static int[] quickSort(int[] arr){
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }
    public static void quickSort(int[] arr, int lowIndex, int highIndex){
        if(lowIndex >= highIndex) return;

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = arr[pivotIndex];
        swap(arr, pivotIndex, highIndex);

        int leftPointer = partition(arr, lowIndex, highIndex, pivot);

        quickSort(arr, lowIndex, leftPointer - 1);
        quickSort(arr, leftPointer + 1, highIndex);

    }

    private static int partition(int[] arr, int lowValue, int highValue, int pivot) {
        int leftPointer = lowValue;
        int rightPointer = highValue - 1;

        while(leftPointer < rightPointer){
            while(arr[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            while(arr[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            swap(arr, leftPointer,rightPointer);
        }
        if(arr[leftPointer] > arr[highValue]){
            swap(arr, leftPointer, highValue);
        } else {
            leftPointer = highValue;
        }
        return leftPointer;
    }

    private static void swap(int[] arr, int a, int b) {
        int curr = arr[a];
        arr[a] = arr[b];
        arr[b] = curr;
    }
}
