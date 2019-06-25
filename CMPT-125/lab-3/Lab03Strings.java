
public class Lab03Strings {

	
	public static void main(String[] args) {
		String s1 = "this is my first string 1,2,3,4 - bye";
		String s2 = "** second!**";
		String s3 = "And a third string!!!";
		System.out.println(s1+s2);
		System.out.println(s1.toUpperCase() + "** ohhh!");
		System.out.println("Third String is \""+s3+"\"");
		System.out.println("the length of s1 is: " +s1.length());
		
		System.out.println("s1 is \""+s1+"\"");
		System.out.println("s3 is \""+s3+"\"");
		
		System.out.println("Assigning s3 = s1;");
		s3 = s1;
		System.out.println("s1 is \""+s1+"\"");
		System.out.println("s3 is \"" + s3 + "\""); 
		
		System.out.println("Concatenating onto s1..."); 
		s1 += " has changed";
		System.out.println("s1 is \""+s1+"\"");
		System.out.println("s3 is \""+s3+"\"");
		
	}

}
