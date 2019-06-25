public String doubleChar(String str) {
//Returns a string where for every char in the original, there are two chars.
 String result = "";
 for(int i = 0; i < str.length(); i++)
 {
   result += str.substring(i, i+1) + str.substring(i, i+1);
 }
 return result;
}