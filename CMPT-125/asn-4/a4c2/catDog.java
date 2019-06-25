public boolean catDog(String str) {
//Return true if the string "cat" and "dog" appear the same number of times in the given string. 
  int cat = 0;
  int dog = 0;
  
  for(int i = 0; i < str.length() - 2; i++)
  {
   if(str.substring(i, i+3).equals("cat"))
   {
    cat++;
   }
   else if(str.substring(i, i+3).equals("dog"))
   {
    dog++;
   }
  }
  if(dog == cat)
  {
   return true;
  }
  else
  {
   return false;
  }
}