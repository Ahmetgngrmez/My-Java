import java.util.Scanner;

public class MyIntegerTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Creating and testing n1 object
        System.out.print("Enter an integer (n1): ");
        MyInteger n1 = new MyInteger(input.nextInt());

        System.out.println("n1 is even? " + n1.isEven());
        System.out.println("n1 is prime? " + n1.isPrime());
        
        // Static method test
        System.out.println("15 is prime? " + MyInteger.isPrime(15));
        
        // char[] conversion test
        char[] chars = {'3', '5', '3', '9'};
        System.out.println("char[] {'3', '5', '3', '9'} converted to int: " + MyInteger.parseInt(chars));
        
        // String conversion test
        System.out.print("Enter a string of digits (s): ");
        String s = input.next();
        System.out.println("String \"" + s + "\" converted to int: " + MyInteger.parseInt(s));

        // Creating and testing n2 object
        System.out.print("Enter an integer (n2): ");
        MyInteger n2 = new MyInteger(input.nextInt());
        
        System.out.println("n2 is odd? " + n2.isOdd());
        System.out.println("45 is odd? " + MyInteger.isOdd(45));

        // Equality tests
        System.out.println("n1 is equal to n2? " + n1.equals(n2));
        System.out.println("n1 is equal to 5? " + n1.equals(5));

        input.close();
    }
}

// MyInteger class, defined in the same file as the driver class (is NOT public).
class MyInteger {
    private int value;

    // Constructor
    public MyInteger(int value) {
        this.value = value;
    }

    // Getter Method
    public int getValue() {
        return value;
    }

    // Instance Methods (Called via an object)
    public boolean isEven() {
        return isEven(value);
    }

    public boolean isOdd() {
        return isOdd(value);
    }

    public boolean isPrime() {
        return isPrime(value);
    }

    // Static Methods (Called via the class name)
    
    // Even Check
    public static boolean isEven(int n) {
        return n % 2 == 0;
    }
    
    public static boolean isEven(MyInteger n) {
        return isEven(n.getValue());
    }
    
    // Odd Check
    public static boolean isOdd(int n) {
        return n % 2 != 0;
    }

    public static boolean isOdd(MyInteger n) {
        return isOdd(n.getValue());
    }

    // Prime Check
    public static boolean isPrime(int num) {
        // Handle edge cases for primality: 1 is not prime, 2 is the smallest prime.
        if (num <= 1) {
            return false;
        }
        if (num == 2) {
            return true;
        }

        // More efficient prime check (only loops up to the square root)
        for (int i = 2; i <= Math.sqrt(num); i++) { 
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(MyInteger o) {
        return isPrime(o.getValue());
    }
    
    // Equality Check Methods
    public boolean equals(int anotherNum) {
        return value == anotherNum;
    }

    public boolean equals(MyInteger o) {
        return value == o.getValue();
    }
    
    // Conversion Methods

    // Converts a char array to an int
    public static int parseInt(char[] numbers) {
        int result = 0;
        for (int i = 0; i < numbers.length; i++) {
            // Subtract '0' to convert the character to its integer value
            result = result * 10 + (numbers[i] - '0');
        }
        return result;
    }

    // Converts a String to an int
    public static int parseInt(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Subtract '0' to convert the character to its integer value
            result = result * 10 + (s.charAt(i) - '0');
        }
        return result;
    }
}