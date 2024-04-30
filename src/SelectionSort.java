import java.util.Collections;
import java.util.List;

public class SelectionSort implements Project6.SortingAlgorithm {
    private int comparisons = 0; // Counter for the number of comparisons

    @Override
    public void sort(List<String> words) {
        // Convert the list of words to an array
        String[] wordsArray = words.toArray(new String[0]);

        // Perform selection sort on the array
        selectionSort(wordsArray);

        // Convert the sorted array back to the list
        words.clear();
        Collections.addAll(words, wordsArray);
    }

    @Override
    public String getName() {
        return "Selection Sort";
    }

    @Override
    public void resetComparisons() {
        comparisons = 0;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    // In-place selection sort method
    private void selectionSort(String[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted section
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (array[j].compareTo(array[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Swap the found minimum element with the first unsorted element
            swap(array, i, minIndex);
        }
    }

    // Helper method to swap elements in the array
    private void swap(String[] array, int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
