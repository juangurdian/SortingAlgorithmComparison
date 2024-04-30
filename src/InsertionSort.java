import java.util.List;

public class InsertionSort implements Project6.SortingAlgorithm {
    private int comparisons = 0; // Counter for the number of comparisons

    @Override
    public void sort(List<String> words) {
        // Convert the list of words to an array
        String[] wordsArray = words.toArray(new String[0]);

        // Perform insertion sort on the array
        insertionSort(wordsArray);

        // Clear the original list
        words.clear();

        // Add the sorted elements back to the list
        for (String word : wordsArray) {
            words.add(word);
        }
    }

    @Override
    public String getName() {
        return "Insertion Sort";
    }

    @Override
    public void resetComparisons() {
        comparisons = 0;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    // In-place insertion sort method
    private void insertionSort(String[] array) {
        int n = array.length;

        for (int i = 1; i < n; i++) {
            String key = array[i];
            int j = i - 1;

            // Compare and shift elements
            while (j >= 0 && array[j].compareTo(key) > 0) {
                comparisons++;
                array[j + 1] = array[j];
                j--;
            }

            // Place key at the correct position
            array[j + 1] = key;
        }
    }
}
