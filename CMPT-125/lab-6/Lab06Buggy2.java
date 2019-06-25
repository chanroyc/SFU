/** 
 *  Lab06Buggy2.java       
 *
 *  @author Scott Kristjanson
 * 
 *
 *
 *********************************************************************/

public class Lab06Buggy2 {
	
	private static final boolean Want_DebugStatements = false;
	
    /** 
     *  Displays the characters in a string one character per line.
     *  Shows the use of Trace output which is controlled by a boolean.
     *  (this is a useful technique for turn on/off Trace output)
     *  
     ******************************************************************/
    public static void main(String[] args) {
              
              String     testStr = "Hello World!";
              int        strLen  = testStr.length();
          
              for (int i=0; i<strLen; i++)
              {
            	 // if Want_DebugStatements is true, we will print this Trace output
            	  //i has to be strictly less than strLen 
                 if (Want_DebugStatements)
                 {
            	      System.out.print  ("Trace -    At step " + i + ":");
            	      System.out.printf (" testStr.length() = " + strLen  );
                      System.out.println(" index = " + i);
                      if (i >= strLen)
                    	  System.out.println("**** YIKES!!! Index i is too large for testStr!");
                 }
                 
                 // Print out the ith character in testStr
                 System.out.print("testStr[" + i + "] = \'" + testStr.charAt(i) + "\'");         
              }
                  
        }
    
}
