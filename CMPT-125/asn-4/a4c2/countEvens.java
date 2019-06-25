public int countEvens(int[] nums) {
//Returns the number of even ints in the given array.
  int result = 0;
  for(int i = 0; i < nums.length; i++)
  {
   if(nums[i] % 2 == 0)
   {
    result++;
   }
   else
   {
   }
  }
  return result;
}