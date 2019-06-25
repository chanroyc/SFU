public boolean groupSum(int start, int[] nums, int target) {
/*Given an array of ints, returns boolean if the array of ints sums to 
*the given target number.
*/
  if (start >= nums.length)
   return (target == 0);
  if (groupSum(start + 1, nums, target - nums[start]))
   return true;
  if (groupSum(start + 1, nums, target))
   return true;
  return false;
}