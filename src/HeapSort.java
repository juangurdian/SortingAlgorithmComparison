import java.util.*;

public class HeapSort implements Project6.SortingAlgorithm {
    private int comparisons = 0; // Counter for the number of comparisons

    @Override
    public void sort(List<String> words) {
        // Convert the list of words to an array
        String[] wordsArray = words.toArray(new String[0]);
        
        // Perform heap sort on the array
        heapSort(wordsArray);
        
        // Convert the sorted array back to the list
        words.clear();
        Collections.addAll(words, wordsArray);
    }

    @Override
    public String getName() {
        return "Heap Sort";
    }

    @Override
    public void resetComparisons() {
        comparisons = 0;
    }

    @Override
    public int getComparisons() {
        return comparisons;
    }

    // Heap sort method
    private void heapSort(String[] array) {
        int n = array.length;
        
        // Build the heap using downheap for each non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {
            downheap(array, n, i);
        }
        
        // Extract elements from the heap one by one and swap with the end of the array
        for (int i = n - 1; i >= 0; i--) {
            // Swap the root (maximum element) with the last element
            swap(array, 0, i);
            
            // Reduce the size of the heap
            downheap(array, i, 0);
        }
    }

    // Downheap method to restore heap-order property
    private void downheap(String[] array, int size, int index) {
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;
        
        while (leftChildIndex < size) {
            int smallerChildIndex = leftChildIndex;

            // Compare the left and right child to find the smaller one
            if (rightChildIndex < size && array[rightChildIndex].compareTo(array[leftChildIndex]) < 0) {
                smallerChildIndex = rightChildIndex;
            }

            // Compare the parent with the smaller child
            comparisons++;
            if (array[index].compareTo(array[smallerChildIndex]) > 0) {
                // Swap the parent and child if necessary
                swap(array, index, smallerChildIndex);
                
                // Update the index to the child's position and continue downheaping
                index = smallerChildIndex;
                
                // Update child indices
                leftChildIndex = 2 * index + 1;
                rightChildIndex = 2 * index + 2;
            } else {
                // No more swaps needed; break the loop
                break;
            }
        }
    }

    // Upheap method to restore heap-order property
    private void upheap(String[] array, int index) {
        int parentIndex = (index - 1) / 2;
        
        while (index > 0 && array[index].compareTo(array[parentIndex]) < 0) {
            comparisons++;
            // Swap the current element with its parent
            swap(array, index, parentIndex);
            
            // Update the index to the parent's position
            index = parentIndex;
            
            // Update the parent index
            parentIndex = (index - 1) / 2;
        }
    }

    // Helper method to swap elements in the array
    private void swap(String[] array, int index1, int index2) {
        String temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
