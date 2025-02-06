import java.util.Random;

class Tester{
    private SortingAlgorithm sa;

    public Tester(SortingAlgorithm sa) {
        this.sa = sa;
    }

    public double singleTest(int size) {
        int[] array = new Random().ints(size, 0, 10000).toArray();
        long startTime = System.nanoTime();
        sa.sort(array);
        return (System.nanoTime() - startTime) / 1e6;
    }

    public void test(int iterations, int size) {
        double total = 0;
        for (int i = 0; i < iterations; i++) {
            total += singleTest(size);
        }
        System.out.println(sa.getClass().getSimpleName() + " average time: " + (total / iterations) + " ms");
    }
}
