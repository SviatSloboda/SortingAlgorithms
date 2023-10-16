public class MergeSort {

    // O(n * log(n))
    public static int[] mergeSort(int[] arr){
        int length = arr.length;
        if(2 > length) return arr;

        int midIndex = length/2;

        int[] leftPart = new int[midIndex];
        int[] rightPart = new int[length - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftPart[i] = arr[i];
        }
        for (int i = midIndex; i < length; i++) {
            rightPart[i - midIndex] = arr[i];
        }
        mergeSort(leftPart);
        mergeSort(rightPart);

        int i = 0, j = 0, k = 0;

        while(i < leftPart.length && j < rightPart.length){
            if(leftPart[i] <= rightPart[j]){
                arr[k] = leftPart[i];
                i++;
            } else {
                arr[k] = rightPart[j];
                j++;
            }
            k++;
        }

        while(i < leftPart.length){
            arr[k] = leftPart[i];
            i++;
            k++;
        }
        while(j < rightPart.length){
            arr[k] = rightPart[j];
            j++;
            k++;
        }
        return arr;
    }
}
