import jsjf.LinkedStack;
import java.util.Arrays;
import java.util.Scanner;
/**
 *Reads a single line of input from the user containing at
 *least one integer and possibly many more. Uses LinkedStack
 *data structure to push all the integers onto stack.
 *Once the program has successfully stacked all the 
 *valid int values, an int array is allocated based on the
 *size of the input. The elements in array are then retrieved
 *from the stack via the .pop() method.
 *The elements in the array are then sorted in ascending order.
 * @author Roy Chan
 * @version  Version 2.0
 *
 */
public class MyIntSort 
{
		public static void main(String[] args)
	{
		/*
		 * Creating and empty stack and declaring variables
		 * needed in the code.
		 */
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		
		String error = "";
		String sarray="";
		int count = 0;
		int number = 0;
		boolean rcvdValidInput = true;

		//Creating scanner object to take user input
		Scanner in = new Scanner(System.in);
		System.out.print("Enter one or more integers: ");
		String string = in.nextLine();
		
		/*
		 * Loop to check each of the scanner's inputs
		 * if they are valid values. If an input is valid, 
		 * then it is pushed into the stack. If it is invalid,
		 * a new empty stack is created and prompts to user
		 * to re-input their integer values.
		 */
		do{
			rcvdValidInput = true;
			Scanner scan2 = new Scanner(string);
			error = "";
			count =0;
			while(scan2.hasNextInt())
				{
					int integer = scan2.nextInt();
					stack.push(integer);
					count++;
				}
			if(scan2.hasNext())
			{
				error = scan2.next();
				System.out.println("Sorry but "+error+" is not an int! Please try again!");
				rcvdValidInput = false;
				count = 0;
				stack = new LinkedStack<Integer>();
				System.out.print("Enter one or more integers: ");
				string = in.nextLine();

			}
			
		}while(!rcvdValidInput);
		
	/*
	 *Count is the size of the stack. A new array of size count
	 *is created.
	 */
	int[] array = new int[count];

	/*
	 *Prints out the number of integers and the stack
	 *using .toString() method
	 */
	String result = stack.toString();
	System.out.println("Number of Integers: "+count);
	System.out.println("myStack: ["+result+"]");
	
	/*
	 *Using the stack.pop method, the elements in the stack
	 *are retrieved and added to the array in the order they
	 *the integers were input.
	 */
	do{
		number = stack.pop();
		array[count-1] = number;
		sarray = number + " "+ sarray;
		count--;
	}while(count>0);
	
	System.out.println("myArray: ["+sarray+"]");
	
	//Array is sorted, then formatted into a string.
	Arrays.sort(array);
	sarray = "";
	for(int i = 0; i<array.length; i++)
	{
		sarray = sarray + array[i] +" ";
	}
	System.out.println("Sorted:  ["+sarray+"]");
	}
}
