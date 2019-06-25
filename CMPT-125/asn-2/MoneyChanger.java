import java.util.*;
public class MoneyChanger 
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int twenty = 0;
		int ten = 0;
		int five = 0;
		int toony = 0;
		int loony = 0;
		int quarter = 0;
		int dime = 0;
		int nickel = 0;
		int penny = 0;
		String money;
		int remainder1 = 0;
		int remainder2 = 0;
		int remainder3 = 0;
		int remainder4 = 0;
		int remainder5 = 0;
		int remainder6 = 0;
		int remainder7 = 0;
		int remainder8 = 0;
		boolean rcvdValidInput = true;
		System.out.println("Enter a monetary amount: ");
		money = scan.nextLine();
		do{
			rcvdValidInput = true;
			Scanner scan2 = new Scanner(money);
			if(!scan2.hasNextDouble())
			{
				System.out.println("\""+money+"\" is not a double" );
				System.out.println("Enter a monetary amount: ");
				money = scan.nextLine();
				rcvdValidInput = false;
			}
		}while(!rcvdValidInput);
		
		
		double d = Double.parseDouble(money);
		d = d*100;
		twenty = (int) (d/2000);
		remainder1 = (int) (d%2000);
		ten = remainder1/1000;
		remainder2 = remainder1%1000;
		five = remainder2/500;
		remainder3 = remainder2%500;
		toony = remainder3/200;
		remainder4 = remainder3%200;
		loony = remainder4/100;
		remainder5 = remainder4%100;
		quarter = remainder5/25;
		remainder6 = remainder5%25;
		dime = remainder6/10;
		remainder7 = remainder6%10;
		nickel = remainder7/5;
		remainder8 = remainder7%5;
		penny = remainder8/1;

		
		
		System.out.println("That's equivalent to: ");
		if (twenty>1)
				System.out.println(twenty+" twenty dollar bills");
			else
				System.out.println(twenty+" twenty dollar bill");
		if (ten>1)
			System.out.println(ten+" ten dollar bills");
			else
				System.out.println(ten+" ten dollar bill");
		if (five>1)
			System.out.println(five+" five dollar bills");
			else
				System.out.println(five+" five dollar bill");
		if (toony>1)
			System.out.println(toony+" toonies");
			else
				System.out.println(toony+" toony");
		if (loony>1)
			System.out.println(loony+" loonies");
			else
				System.out.println(loony+" loony");
		if (quarter>1)
			System.out.println(quarter+" quarters");
			else
				System.out.println(quarter+" quarter");
		if (dime>1)
			System.out.println(dime+" dimes");
			else
				System.out.println(dime+" dime");
		if (nickel>1)
			System.out.println(nickel+" nickels");
			else
				System.out.println(nickel+" nickel");
		if (penny>1)
			System.out.println(penny+" pennies");
			else
				System.out.println(penny+" penny");
		
		
		
		
	}
}
