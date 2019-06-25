import java.util.*;
import java.text.DecimalFormat;
public class Distance 
{
	static double distance(double x1, double y1, double x2, double y2)  
    {  
    return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));  
    }  
public static void main(String[] args)  
		{     

	double x2, x1, y2, y1;  
	double distance;  
	DecimalFormat fmt = new DecimalFormat("0.000");

	Scanner scan = new Scanner (System.in);  

	System.out.print("Specify two (x,y) coordinates as x1, y1, x2, y2: ");  
	x1 = scan.nextDouble();  
	y1 = scan.nextDouble();  
	x2 = scan.nextDouble();    
	y2 = scan.nextDouble();  
	
	distance = distance(x1,y1,x2,y2);
	System.out.println("The distance between the two points is " + fmt.format(distance));  

		}  

}  
          