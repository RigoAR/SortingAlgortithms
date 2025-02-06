import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class KPerformance {
    public static void main(String[] args) throws IOException {
        SortingAlgorithm[] algorithms = {
                new BubbleSort(), new InsertionSort(), new SelectionSort(),
                new ShellSort(), new QuickSort(), new MergeSort(),
        };

        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("performance_k_sorted_report.txt"))) {
            for (SortingAlgorithm algorithm : algorithms) {
                writer.write("Sorting algorithm – " + algorithm.getClass().getSimpleName() + "\n");

                for (int size : sizes) {
                    long totalTime = 0;

                    for (int i = 0; i < 20; i++) {
                        int[] array = generateKSortedArray(size);
                        long startTime = System.nanoTime();
                        algorithm.sort(array);
                        long endTime = System.nanoTime();

                        totalTime += (endTime - startTime);
                    }

                    long avgTime = totalTime / 20 / 1000000;
                    writer.write("Sorted " + size + " elements in " + avgTime + " ms (avg)\n");
                }
                writer.write("\n");
            }
        }
    }

    private static int[] generateKSortedArray(int size) {
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = i;
        }

        int k = 10;
        for (int i = 0; i < size; i++) {
            int swapIndex = i + (int) (Math.random() * (2 * k + 1)) - k;
            if (swapIndex >= 0 && swapIndex < size) {
                int temp = array[i];
                array[i] = array[swapIndex];
                array[swapIndex] = temp;
            }
        }
        return array;
    }
}

