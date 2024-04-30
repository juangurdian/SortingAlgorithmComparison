import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;



public class Project6 {

    interface SortingAlgorithm {
        void sort(List<String> words);

        String getName();

        void resetComparisons();

        int getComparisons();
    }
    public static void main(String[] args) {
        //Open the scanner to recieve input
        Scanner scanner = new Scanner(System.in);

        //Read how many words will need to be sorted
        int numWords = Integer.parseInt(scanner.nextLine());

        //Read the words that need to be sorted
        List<String> words = new ArrayList<>();
        for (int i = 0; i < numWords; i++) {
            words.add(scanner.nextLine());
        }

        //create a list for the sorting algorithms and their classes
        List<SortingAlgorithm> algorithms = new ArrayList<>();
        algorithms.add(new SelectionSort());
        algorithms.add(new InsertionSort());
        algorithms.add(new HeapSort());
        algorithms.add(new MergeSort());
        algorithms.add(new QuickSort());

        //print the header
        System.out.println("Algorithm      | Comparisons | Time (Milliseconds)");
        System.out.println("================+=============+=====================");

        //Now, loop through each of the sorting algorithms
        for(SortingAlgorithm algorithm : algorithms) {
            //create a copy of the workds list for the sorting
            List<String> wordsCopy = new ArrayList<>(words);

            //reset the count for the comparisons
            algorithm.resetComparisons();

            //measure the time that the sorting took
            long startTime = System.nanoTime();
            algorithm.sort(wordsCopy);
            long endTime= System.nanoTime();

            //calulate the time that was taken in miliseconds
            long timeTaken = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

            //print results
            System.out.printf("%-15s | %-12d | %17d%n",
                                algorithm.getName(),
                                algorithm.getComparisons(),
                                timeTaken);
            
            //print the separator
            System.out.println("----------------+-------------+---------------------");
        
        }

        scanner.close();
    }

}