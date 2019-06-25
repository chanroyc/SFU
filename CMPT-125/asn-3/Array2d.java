import java.util.Random;

/**
 * Creats a 2-dimension array that assigns a random number
 * from 1 to 99 to each element in the 2d array randomNum.
 * The program then computes the average of each row in
 * randomNum and then stores into an array of the averages.
 * 
 * @version Version 2.0
 * @author Roy Chan
 *
 */
public class Array2d {
	public static void main(String[] args)
	{
		//Create an array where the average numbers are stored
		double[] avg = new double[5];
		/*
		 * Create a 2d Array. The first index is the number of
		 * rows, and the second index is the number of columns
		 */
		int[][] randomNums = new int[5][10];
		Random generator = new Random();
		int num, i, position;
		String printer = "";
		double sum = 0;
		
		/*
		 * The variable "i" is used for position of the row,
		 * and the variable "position" is used for the position
		 * of the column. The outer for loop will loop until
		 * "i" is strictly smaller than the number of rows.
		 */
		for(i = 0; i<randomNums.length; i++)
		{
			System.out.print("Row "+i+":");
			/* The inner loop will add 10 numbers to a row,
			 * add the numbers together before the loop stops. The
			 * average of the number is then store into the array
			 * "avg" and then printed.
			 */
			for(position = 0; position<10; position++)
			{
				randomNums[i][position] = generator.nextInt(99)+1;
				sum = sum + randomNums[i][position];
				System.out.print(" " +randomNums[i][position]);
			}
			avg[i] = sum/10;
			position = 0;
			sum=0;
			System.out.println(" Avg: "+avg[i]);;
		}
	}
}
