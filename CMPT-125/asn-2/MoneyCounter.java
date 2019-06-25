import java.util.*;

    public class MoneyCounter 
{
           public static void main(String[] args)
           {
        	   Scanner scan = new Scanner(System.in);
        	   double total =0;
        	   int multiplier = 0;
        	   System.out.println("Enter the number of bills and coins you want counted.");
        	   System.out.println("Please enter the number followed by the bill or coin name: ");
        	   int value;
        	   
        	   do{
        		   String input = scan.nextLine();
        		   Scanner scan2 = new Scanner(input);
        		   if (scan2.hasNextInt()){
        			   multiplier = scan2.nextInt();}
        		   if (scan2.hasNext()){
        			  input = scan2.next();}
        		   	  CurrencyAmt currencyAmt = parseCurrency(input);
        		   	  int input_int = getCurrencyValue(currencyAmt);
        		   	  total = (total+multiplier*input_int);
        		   	  value = getCurrencyValue(currencyAmt);
        		   if(!scan2.hasNext()){
        			   value = 1;}
        	   }while(value!=1);
        		   System.out.println("Your total amount of cash is: $"+total/100);
        		   
           }
            enum CurrencyAmt {
                            twenty,
                            ten,
                            five,
                            toony,
                            loony,
                            quarter,
                            dime,
                            nickel,
                            penny,
                            invalidCurrency
                               };
    private static CurrencyAmt parseCurrency(String token)
            {
                    CurrencyAmt currencyType = CurrencyAmt.invalidCurrency;
                   
                    token = token.toLowerCase();
                   
                    /* Compare the input token one by one with the various possibilities for bills and coins.      */
                    /* A shame Java does not support Switches on Strings, but switching on objects makes no sense! */
                    if ((token.compareTo("twenty"  ) == 0) || (token.compareTo("twenties") == 0))
                             currencyType = CurrencyAmt.twenty;
                    if ((token.compareTo("ten"     ) == 0) || (token.compareTo("tens"    ) == 0))
                             currencyType = CurrencyAmt.ten;
                    if ((token.compareTo("five"    ) == 0) || (token.compareTo("fives"   ) == 0))
                             currencyType = CurrencyAmt.five;
                    if ((token.compareTo("toony"   ) == 0) || (token.compareTo("toonies" ) == 0))
                             currencyType = CurrencyAmt.toony;
                    if ((token.compareTo("loony"   ) == 0) || (token.compareTo("loonies" ) == 0))
                         currencyType = CurrencyAmt.loony;
                    if ((token.compareTo("dollar"  ) == 0) || (token.compareTo("dollars" ) == 0))
                         currencyType = CurrencyAmt.loony;
                    if ((token.compareTo("quarter" ) == 0) || (token.compareTo("quarters") == 0))
                             currencyType = CurrencyAmt.quarter;
                    if ((token.compareTo("dime"    ) == 0) || (token.compareTo("dimes"   ) == 0))
                             currencyType = CurrencyAmt.dime;
                    if ((token.compareTo("nickel"  ) == 0) || (token.compareTo("nickels" ) == 0))
                             currencyType = CurrencyAmt.nickel;
                    if ((token.compareTo("penny"   ) == 0) || (token.compareTo("pennies" ) == 0))
                             currencyType = CurrencyAmt.penny;
           
                    return currencyType;
            }
    private static int getCurrencyValue(CurrencyAmt currencyType)
            {
                    int amt = 0;
                   
                    switch(currencyType)
                    {
                    case twenty:
                    	amt = 2000;
                    	break;
                    case ten:
                    	amt = 1000;
                    	break;
                    case five:
                    	amt = 500;
                    	break;
                    case toony:
                    	amt = 200;
                    	break;
                    case loony:
                    	amt = 100;
                    	break;
                    case quarter:
                    	amt = 25;
                    	break;
                    case dime:
                    	amt = 10;
                    	break;
                    case nickel:
                    	amt = 5;
                    	break;
                    case penny:
                    	amt = 1;
                    	break;
                    default:
                    	amt = 0;
                    	break;
                    }
                    /*** Fill in the Switch details here    ***
                     *** One case for each currencyType     ***
                     *** Set amt to what that type is worth ***/
     
                    return amt;
                    	
                    	 
            }

}

