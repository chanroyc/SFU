public class Lab06Buggy3 {
	
	public static void main(String[] args)
	{

		double a = 30.33;
	    double b = 20.00;
		double c =  0.33;
		double x = a - b - c;
		x = Math.ceil(x);
		
		
		if(x%1 == 0)
			// This statement should get executed! What is wrong with the above IF statement?
			// There is actually a rounding error with x = a-b-c because java stores doubles temporarily as binary numbers
			System.out.println("x is an integer");
		else 
			// If this statement gets executed, then something is wrong with the above IF statement!
			System.out.println("x is not an integer! That is not right!"); 
	}
}
