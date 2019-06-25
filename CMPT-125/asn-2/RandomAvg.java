import java.util.Random;
import java.util.Scanner;
import java.text.DecimalFormat;
public class RandomAvg
{

	public static void main(String[] args)
	{
	Random generator = new Random();
	Scanner scan = new Scanner(System.in);
	double  sum       = 0;    // Running Sum Total
	int     num       = 0;    // Used to store the current random number generated in the loop
	int     count     = 0;    // How many lucky random numbers the user requests
	int     smallest  =  999; // To find the smallest, start with a big   number and look for smaller ones
	int     largest   = -999; // To find the largest,  start with a small number and look for bigger ones
	double average;
	DecimalFormat fmt = new DecimalFormat("0.000");


	System.out.print("Enter how many random numbers you want to average: ");
	count = scan.nextInt();

	System.out.print("Your " + count + " lucky numbers are:");

	for (int i=0; i<count; i++)
	  {
	   num   =  generator.nextInt(100)+1; // Random number from 1 to 100
	   sum   += num;
	  
	   System.out.print(" " + num);

	   if (smallest > num)
	       smallest = num;

	   if (largest  < num)
	       largest  = num;
	  }
	average = sum/count;                
	System.out.println("");
	System.out.println("Average = " + fmt.format(average));
	System.out.println("Largest = " + largest  );
	System.out.println("Smallest= " + smallest );
	}
}