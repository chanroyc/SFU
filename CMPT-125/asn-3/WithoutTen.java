import java.util.Arrays;
import java.util.Scanner;

/**
 * Reads a single line of input from the user
 * containing at least one and up to 10 integers. 
 * The program stores these integers an in int[] array
 * of length 10.
 * @author Roy Chan
 * @version Version 2.0
 * 
 */
public class WithoutTen 
{
	public static void main(String[] args)
	{
		//Declare variables that are needed in the code.
		String string = "";
		int[] array = new int[10];
		String input = "";
		int length;
		int i = 0;
		
		System.out.println("Enter up to 10 integers: ");
		
		//Creating scanner object to take user input.
		Scanner scan = new Scanner(System.in);
		
		/*
		 *Loop to check if the length of the input exceeds 20 integers
		 *If length of the input exceeds 10 integers, then it will
		 *prompt the user to input less than 10 integers 
		 */     
		do
		{
			input = scan.nextLine();
			length = input.length();
			if(length%2==0)
			{
				length = length/2;
			}
			else
				length = length/2+1;
			if(length>10)
			{
				System.out.println("Error: Enter up to 10 integers");
			}
		}while(length>10);
		
		// Creating second scanner object to scan the inputs and add them into the array
		Scanner scan2 = new Scanner(input);
		while(scan2.hasNextInt())
		{
			array[i] = scan2.nextInt();
			i++;
		}
		
		//Changing int array into a str array so that it is in printable form.
		string = Arrays.toString(array);
		System.out.println("Array before call to withoutTen:"+string);

		//Calling the method withoutTen to remove tens and re-ordering the string
		withoutTen(array);
		
	}
	
	/**
	 *  The Method withoutTen removes all 10's and shifts
     * left towards the start of the array.
     *@param nums -  The actual parameter of an int array is
	 * passed through this formal parameter
	 */
	public static void withoutTen(int[] nums)
	{
		int counter =0;
		
		/*
		 * While-loop as long as the counter is smaller than the length of the string to 
		 * check every index of the array for 10's, if the index of an array
		 * is equal to 10, then a zero will replace it.
		 */
		while(counter<nums.length)
		{
			if(nums[counter]==10)
			{
				nums[counter] = 0;
			}
			counter++;
		}
		counter = 0;
		/*
		 * While-loop as long as the counter is smaller than the length of the string.
		 * "Counter" will be the variable defined as the index of the array. Whereas,
		 * "Counter2" will be the variable where the first zero is located. A number other
		 * than zero is located, it will then replace index "Counter2" (first zero) with index
		 * "counter2" (first number that is not zero). Then the integer 0 will replace the number
		 * at the previous index "counter".
		 */
		int counter2 = 0;
		while(counter<nums.length)
		{
			if(nums[counter]==0)
			{
				counter++;
			}
			else{
				nums[counter2] = nums[counter];
				nums[counter] = 0;
				counter2++;
				counter++;
				}
		}
		//Array is changed from type int to str so it is printable.
		String string = Arrays.toString(nums);
		System.out.println("Array after call to withoutTen: "+string);
		}
}
