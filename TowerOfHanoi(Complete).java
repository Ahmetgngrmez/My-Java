import java.util.Scanner;

public class TowerOfHanoiRefactored {

    private static int moveDisks(int n, char sourceTower, char destinationTower, char auxiliaryTower) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + sourceTower + " to " + destinationTower);
            return 1; 
        } 
        else {
            int moveCount = 0;
            // Step 1: Move n-1 disks from the source tower to the auxiliary tower.
            moveCount += moveDisks(n - 1, sourceTower, auxiliaryTower, destinationTower);

            // Step 2: Move the remaining largest disk (disk n) from the source to the destination tower.
            System.out.println("Move disk " + n + " from " + sourceTower + " to " + destinationTower);
            moveCount++; // Increment the count for this move.

            // Step 3: Move the n-1 disks from the auxiliary tower to the destination tower.
            moveCount += moveDisks(n - 1, auxiliaryTower, destinationTower, sourceTower);

            return moveCount;
        }
    }

    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            System.out.print("Enter the number of disks: ");
            int n = input.nextInt();

            System.out.println("\nThe moves are:");

            // Call the recursive method and store the returned total number of moves.
            int totalMoves = moveDisks(n, 'A', 'B', 'C');

            // Print the total number of moves performed to solve the problem.
            System.out.println("\nThe total number of moves is " + totalMoves + ".");
        }
    }
}