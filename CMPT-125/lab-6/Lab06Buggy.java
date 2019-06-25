/** 
 *  Lab06Buggy.java       
 *
 *  @author Scott Kristjanson
 * 
 *
 *
 *********************************************************************/
import java.text.DecimalFormat;

public class Lab06Buggy {
	private static final int MAX_NUM = 9;
	
    /** 
     *  Calculates the Average Value of Odd Numbers from 1 to 9
     *  Rounds the answer to 3 decimal places
     *  
     ******************************************************************/
    public static void main(String[] args) {
              
              Integer    sum   = 0;
              int        count = 0;
              double     avg   = 0;
          
              for (int i=1; i<=MAX_NUM; i+=2)
              {
            	 sum   += i; // Add i to sum
            	 count += 1; // Add 1 to count
            	 
            	 // The count stayed constantly at zero because 0*1 is 0, this does not increase count when loop is finished
              }
     
              // Calculate the average and display it to three decimal places
              avg = sum/count;
              DecimalFormat fmt = new DecimalFormat ("0.000");
              System.out.println("Average = " + fmt.format(avg));
        }
    
}
