public int countCode(String str) {
//Returns a number of times that the string "code" appears anywhere in the given string. Any letter in place of "d" counts.
  int result = 0;
  for(int i = 0; i < str.length() - 3; i++)
  {
   if(str.substring(i, i+2).equals("co") && str.substring(i+3, i+4).equals("e"))
   {
    result++;
   }
  }
  return result;
}