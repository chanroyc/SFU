
public class Lab06Buggy4 {
	
	
	public static void main(String[] args)
	{
	String moneyStr = "PENNY";
	
	moneyStr = moneyStr.toLowerCase();
	
	// The "==" operator compares the reference object, not the string itself
	// Therefore .equals is used instead of the "==" operator
	if (moneyStr.equals("penny") || moneyStr.equals("pennies")){
      System.out.println("The Strings match! " + "penny == " + moneyStr);
	}else{
	  System.err.println("Error! Strings do not match! " + "penny != " + moneyStr + "! But Why??");
	}
	
	}

}
