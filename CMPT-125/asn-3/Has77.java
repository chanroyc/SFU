import java.util.Scanner;
/**
 * Returns boolean value based on the content of nums,
 * which is an array of ints. The method returns true
 * if the array contains two 7's next to each other,
 * or there are two 7's seperated by one element such as
 * with {7, 1, 7}.
 * @author Roy Chan
 * @version Version 2.0
 *
 */
public class Has77 
{
	public static void main(String[] args)
	{
		String string = ""; 
		String input; 
		int length; 
		int i = 0;
		int[] array = new int[20];
		boolean result;
		
		
		System.out.println("Enter up to 20 integers: ");
		
		//Create a new scanner object to store the input of user
		Scanner scan = new Scanner(System.in);
		
		
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
			if(length>20)
			{
				System.out.println("Error: Enter up to 20 integers");
			}
		}while(length>20);
		
		// Creating second scanner object to scan the inputs and add them into the array
		 
		Scanner scan2 = new Scanner(input);
		while(scan2.hasNextInt())
		{
			array[i] = scan2.nextInt();
			i++;
		}
		
		/*
		 *Calling the method has77 by passing the array created above
		 *by user input. 
		 *The boolean value will be stored into the variable "result".
		 */
		result = has77(array);
		
		/*
		 * Instead of removing all the zeroes from the array, the inputs will be stored
		 * into a string via the for loop method. "i" is the length of the input in this case
		 * ("i" was created when storing input integers into the array)
		 */
		for(int printer=0; printer<i; printer++)
		{
			string = string +" "+ array[printer];
		}
		
		//Printing out the result.
		System.out.println("Given int[] array ["+string+" ] Has77 returned "+result);
		
	}
	
	/**
	 * 
	 * @param nums -  The actual parameter of an int array is
	 * passed through this formal parameter.
	 * 
	 * @return Returns a boolean variable depending on the
	 * presence of the number 7 in the array.
	 * 
	 */
	public static boolean has77(int[] nums)
	{
		int i = 0;
		boolean rcv = false;
		/*
		 *Use "i" as a counter in a while-loop. The loop will run as long as
		 *"i" is smaller than the length of the array (to check all numbers)
		 */
		
		while(i<nums.length)
		{
			/*
			 *If number at the array index of "i" is equal to 7, the loop
			 *break. Otherwise, the loop will continue until the last integer
			 *in the array to check for 7's. The method will then return the
			 *boolean variable rcv.
			 */
			if(nums[i]==7)
			{
				rcv = true;
				break;
			}
			else
				rcv = false;
			i++;
		}
		return rcv;
	}

}
