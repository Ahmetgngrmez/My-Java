public class Complex implements Comparable<Complex>, Cloneable {
 private double a;
 private double b;
 public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }
 public double getRealPart() {
 return a;
    }
 public double getImaginaryPart() {
 return b;
    }
 public Complex add(Complex other) {
 return new Complex(a + other.a, b + other.b);
   }
 public Complex subtract(Complex other) {
 return new Complex(a - other.a, b - other.b);
    }
 public Complex multiply(Complex other) {
 return new Complex(a * other.a - b * other.b, a * other.b + b * other.a);
    }
 public Complex divide(Complex other) {
 return new Complex((a * other.a + b * other.b) / (other.a * other.a + other.b * other.b), (b * other.a - a * other.b) / (other.a * 
other.a + other.b * other.b));
    }
 public double abs() {
 return Math.sqrt(a * a + b * b);
    }
    @Override
 public String toString() {
 return a + " + " + b + "i";
    }
    @Override
 public boolean equals(Object obj) {
 if (this == obj) return true;
 if (obj == null || getClass() != obj.getClass()) return false;
 Complex other = (Complex) obj;
 return this.a == other.a && this.b == other.b;
    }
    @Override
 public int compareTo(Complex other) {
 return Double.compare(a, other.a);
    }
    @Override
 public Object clone() {
 return new Complex(a, b);
    }
}