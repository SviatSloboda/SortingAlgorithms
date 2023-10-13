public class BubbleSort {
    public static int[] bubbleSort(int[] arr){
        boolean notSorted = true;
        while (notSorted){
            notSorted = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i+1]){
                    notSorted = true;
                    int curr = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = curr;
                }
            }
        }
        return arr;
    }
}
