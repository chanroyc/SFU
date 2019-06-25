
import java.text.DecimalFormat;
import java.util.Scanner;
/**
 * 
 * @author Roy Chan
 * @version Lab04
 * 
 * Demonstrates the use of the Scanner class to read numeric data.
 * Modified by Roy Chan to demonstrate input validation
 * by checking for and discarding any non-integer input values for
 * the number of miles and re-prompting the user for an integer
 * value. If the user inputs a negative distance, the absolute
 * value is used.
 * 
 */
public class Lab04Doc {

	public static int add(int a, int b)
	{
		int sum = a+b;
		return sum;
	}
	   /**
	    * Calculates mileage based on distance and fuel used as entered by user.
	    * <p>
	    * This method is the main method for this program and accepts two inputs from the user: <ul>
	    * <li>Number of miles travelled (must be an integer)
	    * <li>Number of gallons of gas used (must be a positive double value)
	    * </ul>
	    * This routine then outputs the mileage in miles per gallon
	    * <p>
	    *If the user inputs a non-integer for the number of miles travelled,
	    *the program will loop prompting the user for an integer until one is
	    *entered.
	    *
	    *@param miles nteger number of files travelled
	    *@param gallons number of gallons used
	    *@param args is not used
	    *@return the calculated mileage to three decimal places
	    *
	    */
	public static void main(String[] args) {
	      int miles;
	      double gallons, mpg;
	      
	      // Round the output to three decimal places
	      DecimalFormat fmt = new DecimalFormat ("0.###");
	      
	      Scanner scan = new Scanner(System.in);

	      System.out.print("Enter the number of miles: ");
	      while (!scan.hasNextInt())
	      {
	    	  String badInput;
	    	  
	    	  badInput = scan.next(); // Discard current token, its not an integer
	    	  System.out.print("\""+badInput+"\" is not an integer.  ");
	    	  System.out.print("Please enter an integer number of miles: ");
	      } 
	      miles = Math.abs(scan.nextInt());

	      System.out.print("Enter the gallons of fuel used: ");
	      gallons = scan.nextDouble();

	      mpg = miles / gallons;
	      System.out.println("Miles Per Gallon: " + fmt.format(mpg));
	      System.out.println("Add (1, 1)=" + Lab04Doc.add(1,1));
	      scan.close();

	}

}
