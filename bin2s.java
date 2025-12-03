import java.util.Scanner;

public class bin2s {  
  public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.print("Enter a binary number: ");
	String binaryString = input.nextLine();
	try {
      System.out.println(bin2Dec(binaryString));
	}
	catch (NumberFormatException ex) {
	  System.out.println(ex.getMessage());
	}
  }

  public static int bin2Dec(String binaryString) {
    int value = 0;

    for (int i = 0; i < binaryString.length(); i++) {
      char ch = binaryString.charAt(i);
      if (ch == '0' || ch == '1')
        value = value * 2 + binaryString.charAt(i) - '0';
      else
        throw new NumberFormatException("Not a binary number: " + binaryString);
    }

    return value;
  }
}
