import java.util.*;

public class QuickSort implements Project6.SortingAlgorithm {
    private int comparisons = 0; // Counter for the number of comparisons

    @Override
    public void sort(List<String> words) {
        // Convert the list of words to an array
        String[] wordsArray = words.toArray(new String[0]);
        
        // Perform quicksort on the array
        quickSortInPlace(wordsArray, 0, wordsArray.length - 1);
        
        // Convert the sorted array back to the list
        words.clear();
        Collections.addAll(words, wordsArray);
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }

    @Override
    public void resetComparisons() {
        comparisons = 0;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    // quickSortInPlace sorts the array using a quick sort approach
    private void quickSortInPlace(String[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        
        // Partition the array and get the new pivot index
        int pivotIndex = partition(array, left, right);
        
        // Recursively sort the left and right parts
        quickSortInPlace(array, left, pivotIndex - 1);
        quickSortInPlace(array, pivotIndex + 1, right);
    }

    // Partition the array and return the index of the pivot element
    private int partition(String[] array, int left, int right) {
        // Use the last element as the pivot
        String pivot = array[right];
        int pivotIndex = left;
        
        for (int i = left; i < right; i++) {
            comparisons++;
            // Compare current element with the pivot
            if (array[i].compareTo(pivot) <= 0) {
                // Swap elements if necessary
                swap(array, i, pivotIndex);
                pivotIndex++;
            }
        }
        
        // Swap the pivot element with the element at pivotIndex
        swap(array, pivotIndex, right);
        
        return pivotIndex;
    }

    // Helper method to swap elements in the array
    private void swap(String[] array, int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
