import java.util.*;
import java.text.DecimalFormat;
public class AvgNums
{
	public static void main(String[] args)
	{
                   
		DecimalFormat fmt = new DecimalFormat("0.000");
		Scanner scan = new Scanner(System.in);
                   
        System.out.println("Enter up to 10 numbers to average: ");
        String string = scan.nextLine();
                   
        int counter = 0;
        double sum =0;        
        boolean rcvdValidInput = true;
     
                   
        do{
        	rcvdValidInput = true;
        	Scanner scan2 = new Scanner(string);
        	while(scan2.hasNextInt())
            {
            rcvdValidInput = true;
            sum+=scan2.nextInt();
            counter++;
            }
            if (counter>10){
            	rcvdValidInput = false;
            	counter = 0;
            	sum = 0;
            	System.out.println("ERROR: You entered more than 10 numbers. ");
            	System.out.println("Enter up to 10 numbers to average: ");
            	string = scan.nextLine();
            	}else{
            		continue;
            		  }
        	}while(!rcvdValidInput);     
            double average = sum/counter;
            System.out.println("The average is: "+fmt.format(average));
     
	}      
}

