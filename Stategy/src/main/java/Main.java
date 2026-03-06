import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int smallSize = 1000;
        int largeSize = 100000;

        int[] smallData = generateRandomArray(smallSize);
        int[] largeData = generateRandomArray(largeSize);

        testStrategy("Bubble Sort", new BubbleSortStrategy(), smallData, largeData);
        testStrategy("Merge Sort", new MergeSortStrategy(), smallData, largeData);
        testStrategy("Quick Sort", new QuickSortStrategy(), smallData, largeData);
    }

    private static void testStrategy(String name, SortStrategy strategy, int[] small, int[] large) {

        SorterContext context = new SorterContext(strategy);

        int[] smallCopy = Arrays.copyOf(small, small.length);
        int[] largeCopy = Arrays.copyOf(large, large.length);

        long start = System.nanoTime();
        context.sort(smallCopy);
        long end = System.nanoTime();

        System.out.println(name + " small dataset: " + (end - start) + " ns");

        start = System.nanoTime();
        context.sort(largeCopy);
        end = System.nanoTime();

        System.out.println(name + " large dataset: " + (end - start) + " ns");

        System.out.println();
    }

    private static int[] generateRandomArray(int size) {

        Random random = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100000);
        }

        return array;
    }
}