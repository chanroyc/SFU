import java.util.Scanner;

public class Lab03Scanner {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int miles;
		System.out.println("Enter the number of miles: ");
		miles = scan.nextInt();
		double gallons;
		System.out.println("Enter gas usage in gallons: ");
		gallons = scan.nextDouble();
		double mpg = miles/gallons;
		System.out.println("Miles Per Gallon "+mpg);
	}

}
