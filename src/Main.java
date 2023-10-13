import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt();
        }
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    //O(n2);
    public static int[] bubbleSort(int[] arr) {
        boolean notSorted = true;
        while (notSorted) {
            notSorted = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    notSorted = true;
                    int curr = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = curr;
                }
            }
        }
        return arr;
    }

    //O(n2);
    public static int[] selectionSort(int[] arr) {
        int length = arr.length;

        for (int i = 0; i < length - 1; i++) {
            int min = arr[i];
            int indexOfMin = i;
            for (int j = i + 1; j < length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    indexOfMin = j;
                }
            }
            int curr = arr[i];
            arr[i] = arr[indexOfMin];
            arr[indexOfMin] = curr;
        }
        return arr;
    }

    //O(n2);
    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int j = i - 1; //begin value for while loop
            while (j >= 0 && arr[j] > curr) {
                arr[j + 1] = arr[j]; //for our value will be assigned value before
                j--; // for the iteration
            }
            arr[j + 1] = curr; // value before will be assigned our current value
        }
        return arr;
    }

    // O(n * log(n))
    public static int[] mergeSort(int[] arr) {
        int length = arr.length;
        if (arr.length < 2) return arr;

        int midIndex = length / 2;

        int[] leftHalfOfArray = new int[midIndex];
        int[] rightHalfOfArray = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalfOfArray[i] = arr[i];
        }
        for (int i = midIndex; i < length; i++) {
            rightHalfOfArray[i - midIndex] = arr[i];
        }

        //we will divide here our array on number of length of our arrays.
        mergeSort(leftHalfOfArray);
        mergeSort(rightHalfOfArray);


        int leftLength = leftHalfOfArray.length;
        int rightLength = rightHalfOfArray.length;

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < leftLength && j < rightLength) {
            if (leftHalfOfArray[i] <= rightHalfOfArray[j]) {
                arr[k] = leftHalfOfArray[i];
                i++;
            } else {
                arr[k] = rightHalfOfArray[j];
                j++;
            }
            k++;
        }
        while (i < leftLength) {
            arr[k] = leftHalfOfArray[i];
            i++;
            k++;
        }
        while (j < rightLength) {
            arr[k] = rightHalfOfArray[j];
            j++;
            k++;
        }

        return arr;
    }


    // O(n * log(n))
    private static int[] quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
        return array;
    }

    private static void quicksort(int[] array, int lowIndex, int highIndex) {

        if (lowIndex >= highIndex) {    // not to sort 1 or 0 element array;
            return;
        }

        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, highIndex);

        int leftPointer = partition(array, lowIndex, highIndex, pivot);

        quicksort(array, lowIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, highIndex);

    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        int leftPointer = lowIndex;
        int rightPointer = highIndex - 1;

        while (leftPointer < rightPointer) {  //we are iterating through a loop until a left and a right pointer meet in the same position

            // Walk from the left until we find a number greater than the pivot, or hit the right pointer.
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            // Walk from the right until we find a number less than the pivot, or hit the left pointer.
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            // we swap these two pointers
            swap(array, leftPointer, rightPointer);
        }
        // we swap our pivot(highIndex) with a meet position
        if (array[leftPointer] > array[highIndex]) {
            swap(array, leftPointer, highIndex);
        } else {
            leftPointer = highIndex;
        }

        return leftPointer;
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    //bucketSort
    //shellSort
    //Heap Sort
}







