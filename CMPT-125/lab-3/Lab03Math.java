import java.util.Scanner;
public class Lab03Math {
	public static void main(String[] args) {
		int a, b, c; // ax^2 bx + c
		double root1, root2;
		Scanner scan = new Scanner (System.in);
		
		System.out.println("Enter the coefficient of x squared: ");
		a = scan.nextInt();
		System.out.println("Enter the coefficient of x: ");
		b = scan.nextInt();
		System.out.println("Enter the constant");
		c = scan.nextInt();
		double discriminant = (double) (Math.pow(b, 2) - (4*a*c));
		
		root1 = (-b + Math.sqrt(discriminant)) /(2*a);
		root2 = (-b - Math.sqrt(discriminant)) /(2*a);
		System.out.println("Root #1: " +root1);
		System.out.println("Root #2: " +root2);
			
	}
}
