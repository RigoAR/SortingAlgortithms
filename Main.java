public class Main {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        SortingAlgorithm[] algorithms = {
                new BubbleSort(), new InsertionSort(), new SelectionSort(),
                new ShellSort(), new QuickSort(), new MergeSort()
        };

        for (SortingAlgorithm algorithm : algorithms) {
            int[] sortedArray = algorithm.sort(array.clone());
            System.out.println(algorithm.getClass().getSimpleName() + ": " + java.util.Arrays.toString(sortedArray));
        }

        for (SortingAlgorithm algorithm : algorithms) {
            Tester tester = new Tester(algorithm);
            tester.test(10, 1000);
        }
    }
}