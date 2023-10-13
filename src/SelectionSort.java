public class SelectionSort {

    // O(n^2)
    public static int[] selectionSort(int[] arr){
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            int minValue = arr[i];
            int minValueIndex = i;
            for (int j = i + 1; j < length; j++) {
                if(minValue > arr[j]){
                    minValue = arr[j];
                    minValueIndex = j;
                }
            }
            int curr = arr[i];
            arr[i] = arr[minValueIndex];
            arr[minValueIndex] = curr;
        }
        return arr;
    }
}
