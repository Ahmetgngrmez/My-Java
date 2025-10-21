public class bonus4 {
    public static void main(String[] args) {
        // Test for different values of n
        simulateDiceRolls(6);
        simulateDiceRolls(60);
        simulateDiceRolls(600);
        simulateDiceRolls(6000);
    }

    public static void simulateDiceRolls(int n) {
        long[] distribution = new long[6]; // Array to store counts for sides 1 to 6

        // Roll the dice n times
        for (int i = 0; i < n; i++) {
            int roll = customRandom() % 6 + 1; // Random number between 1 and 6
            distribution[roll - 1]++; // Increment count for the rolled number
        }

        // Display the results
        System.out.println("Dice roll distribution for n = " + n + ":");
        for (int i = 0; i < 6; i++) {
            long count = distribution[i];
            double percentage = (double) count / n * 100;
            System.out.printf("Side %d: %d (%.2f%%)%n", i + 1, count, percentage);
        }
        System.out.println();
    }

    // Custom random number generator (linear congruential generator)
    public static int customRandom() {
        long a = 1664525;
        long c = 1013904223;
        long m = (1L << 31);
        long seed = System.nanoTime(); // Use current time as seed
        return (int) ((a * seed + c) % m);
    }
}
