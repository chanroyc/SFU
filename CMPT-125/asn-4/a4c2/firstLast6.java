public boolean firstLast6(int[] nums) {
//Given an array of ints, returns boolean if 6 appears as either the first or last element in the array
if(nums[0] == 6 || nums[nums.length - 1] == 6)
{
return true;
}
else
{
return false;
}
}