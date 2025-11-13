import java.math.*;
import java.util.Scanner;

/**
 * Main class to demonstrate arithmetic operations with Rational numbers using BigInteger.
 */
public class RationalNumberCalculator {
    public static void main(String[] args) {
        // Prompt the user to enter two Rational numbers
        Scanner input = new Scanner(System.in);
        
        // Get input for the first rational number (numerator and denominator)
        System.out.print("Enter rational r1 with numerator and denominator separated by a space: ");
        String n1 = input.next();
        String d1 = input.next();

        // Get input for the second rational number (numerator and denominator)
        System.out.print("Enter rational r2 with numerator and denominator separated by a space: ");
        String n2 = input.next();
        String d2 = input.next();

        // Create Rational objects using the input strings converted to BigIntegers
        BigRational r1 = new BigRational(new BigInteger(n1), new BigInteger(d1));
        BigRational r2 = new BigRational(new BigInteger(n2), new BigInteger(d2));

        // Display results of arithmetic operations
        System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));       // Addition
        System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));  // Subtraction
        System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));  // Multiplication
        System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));    // Division
        
        // Display the double value of the second rational number
        System.out.println(r2 + " is " + r2.doubleValue());
        
        input.close();
    }
}

/**
 * A class representing a rational number with numerator and denominator 
 * stored as BigInteger for arbitrary precision arithmetic.
 */
class BigRational extends Number implements Comparable<BigRational> {
    // Data fields for numerator and denominator
    private BigInteger numerator = BigInteger.ZERO;
    private BigInteger denominator = BigInteger.ONE;

    /** Construct a rational with default properties (0/1) */
    public BigRational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    /** * Construct a rational with specified numerator and denominator.
     * It automatically simplifies the fraction by dividing by the GCD.
     */
    public BigRational(BigInteger numerator, BigInteger denominator) {
        // Calculate the greatest common divisor to simplify the fraction
        BigInteger gcd = gcd(numerator, denominator);

        // Adjust the sign: keep the denominator positive
        if (denominator.compareTo(BigInteger.ZERO) < 0) {
            this.numerator = numerator.multiply(new BigInteger("-1")).divide(gcd);
        } else {
            this.numerator = numerator.divide(gcd);
        }
        this.denominator = denominator.abs().divide(gcd);
    }

    /** * Helper method to find GCD (Greatest Common Divisor) of two numbers.
     * Note: The original brute-force implementation is slow for very large numbers.
     * BigInteger's built-in gcd() method is recommended for production, 
     * but keeping logic similar to your request.
     */
    private static BigInteger gcd(BigInteger n, BigInteger d) {
        BigInteger n1 = n.abs();
        BigInteger n2 = d.abs();
        
        // Using the standard built-in GCD method for better performance with BigInteger
        // (The original loop logic is extremely slow for large BigIntegers)
        return n1.gcd(n2); 
    }

    /** Return numerator */
    public BigInteger getNumerator() {
        return numerator;
    }

    /** Return denominator */
    public BigInteger getDenominator() {
        return denominator;
    }

    /** Add a rational number to this rational: (a/b) + (c/d) = (ad + bc) / bd */
    public BigRational add(BigRational secondBigRational) {
        BigInteger n = numerator.multiply(secondBigRational.getDenominator())
                .add(denominator.multiply(secondBigRational.getNumerator()));
        BigInteger d = denominator.multiply(secondBigRational.getDenominator());
        return new BigRational(n, d);
    }

    /** Subtract a rational number from this rational: (a/b) - (c/d) = (ad - bc) / bd */
    public BigRational subtract(BigRational secondBigRational) {
        BigInteger n = numerator.multiply(secondBigRational.getDenominator())
                .subtract(denominator.multiply(secondBigRational.getNumerator()));
        BigInteger d = denominator.multiply(secondBigRational.getDenominator());
        return new BigRational(n, d);
    }

    /** Multiply a rational number to this rational: (a/b) * (c/d) = ac / bd */
    public BigRational multiply(BigRational secondBigRational) {
        BigInteger n = numerator.multiply(secondBigRational.getNumerator());
        BigInteger d = denominator.multiply(secondBigRational.getDenominator());
        return new BigRational(n, d);
    }

    /** Divide a rational number from this rational: (a/b) / (c/d) = ad / bc */
    public BigRational divide(BigRational secondBigRational) {
        BigInteger n = numerator.multiply(secondBigRational.getDenominator());
        BigInteger d = denominator.multiply(secondBigRational.numerator);
        return new BigRational(n, d);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE))
            return numerator + "";
        else
            return numerator + "/" + denominator;
    }

    @Override 
    /** Override the equals method in the Object class */
    public boolean equals(Object parm1) {
        // Two rationals are equal if their difference is zero
        if ((this.subtract((BigRational)(parm1))).getNumerator().equals(BigInteger.ZERO))
            return true;
        else
            return false;
    }

    @Override 
    /** Override the hashCode method in the Object class */
    public int hashCode() {
        return new Double(this.doubleValue()).hashCode();
    }

    @Override 
    /** Override the abstract intValue method in java.lang.Number */
    public int intValue() {
        return (int)doubleValue();
    }

    @Override 
    /** Override the abstract floatValue method in java.lang.Number */
    public float floatValue() {
        return (float)doubleValue();
    }

    @Override 
    /** Override the doubleValue method in java.lang.Number */
    public double doubleValue() {
        // Convert BigIntegers to double for division
        return numerator.doubleValue() / denominator.doubleValue();
    }

    @Override 
    /** Override the abstract longValue method in java.lang.Number */
    public long longValue() {
        return (long)doubleValue();
    }

    @Override
    /** Implement the compareTo method from Comparable interface */
    public int compareTo(BigRational o) {
        // Compare based on the sign of the difference
        BigInteger differenceNumerator = (this.subtract(o)).getNumerator();
        
        if (differenceNumerator.compareTo(BigInteger.ZERO) > 0)
            return 1;
        else if (differenceNumerator.compareTo(BigInteger.ZERO) < 0)
            return -1;
        else
            return 0;
    }
}