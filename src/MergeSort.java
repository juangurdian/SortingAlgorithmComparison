import java.util.*;

public class MergeSort implements Project6.SortingAlgorithm {
    private int comparisons = 0;

    @Override
    public void sort(List<String> words) {
        // Convert the list of words to an array
        String[] wordsArray = words.toArray(new String[0]);
        
        // Perform merge sort on the array
        mergeSort(wordsArray, 0, wordsArray.length - 1);
        
        // Convert the sorted array back to the list
        words.clear();
        Collections.addAll(words, wordsArray);
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }

    @Override
    public void resetComparisons() {
        comparisons = 0;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    private void mergeSort(String[] array, int left, int right) {
        if (left < right) {
            // Calculate the midpoint
            int mid = left + (right - left) / 2;
            
            // Sort the left half
            mergeSort(array, left, mid);
            
            // Sort the right half
            mergeSort(array, mid + 1, right);
            
            // Merge the sorted halves
            merge(array, left, mid, right);
        }
    }

    private void merge(String[] array, int left, int mid, int right) {
        // Temporary arrays to hold left and right halves
        String[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        String[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
        
        // Indices for the left, right, and merged arrays
        int leftIndex = 0, rightIndex = 0, mergedIndex = left;
        
        // Merge the left and right halves
        while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
            comparisons++;
            if (leftArray[leftIndex].compareTo(rightArray[rightIndex]) <= 0) {
                array[mergedIndex] = leftArray[leftIndex];
                leftIndex++;
            } else {
                array[mergedIndex] = rightArray[rightIndex];
                rightIndex++;
            }
            mergedIndex++;
        }

        // Copy any remaining elements from the left half
        while (leftIndex < leftArray.length) {
            array[mergedIndex] = leftArray[leftIndex];
            leftIndex++;
            mergedIndex++;
        }

        // Copy any remaining elements from the right half
        while (rightIndex < rightArray.length) {
            array[mergedIndex] = rightArray[rightIndex];
            rightIndex++;
            mergedIndex++;
        }
    }
}
