import java.util.Scanner;


public class labwork8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        int counter = 0;

        for (int a=0;a < 10;a++) {

            int num = input.nextInt();

            boolean found = false;

            for (int i = 0; i < counter; i++) {
                if (numbers[i] == num) {
                    found = true;
                    break;
                }
            }

            if (!found) { 
                numbers[counter] = num;
                counter++;
            } 
        }
        for(int j=0;j<counter;j++){
            System.out.print(numbers[j] +" ");
            

        }
        System.out.println("Number of distinct numbers: "+counter);
        System.out.println("Distinct numbers are:");
        input.close();
    }
}