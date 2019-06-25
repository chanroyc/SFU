public int sum13(int[] nums) {
/*Returns the sum of the numbers in the array, returning 0 for an empty array.
*Any number after a "13" is not counted.
*/
  int result = 0;
  for(int i = 0; i < nums.length; i++)
  {
   if(nums.length >= 0)
   {
    if(nums[i] == 13 || i != 0 && nums[i - 1] == 13)
    {
    }
    else
    {
     result += nums[i];
    }
   }
   else
   {
    return 0;
   }
  }
  return result;
}