public class CmdLine {
	/**
	 * Method that prints the number of command line parameters
	 * passed in args[]. Program prints each of the command
	 * line arguments on seperate lines.
	 * @param args - Parameter of command line arguments entered
	 * via user input.
	 * 
	 * @version Version 2.0
	 * @author Roy Chan
	 */
	public static void main(String[] args)
	{
		/*
		 * Prints out the number of arguments in the 
		 * command line parameters.
		 */
		System.out.println("There are " + args.length + " command line parameters");
		 /*
		  * For loop will print out each command line argument
		  * until the end of the command line parameters.
		  */
		for (int i=0; i<args.length;i++)
			System.out.println("\""+args[i]+"\"");
	}
}
