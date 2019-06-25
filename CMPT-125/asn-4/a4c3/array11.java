public int array11(int[] nums, int index) {
//Given an array of ints, computes recursively the number of times 11 appears in the array
 int result = 0;
 if(index >= nums.length) {
   return 0;
 } 
 if(nums[index] == 11) {
   result++;
 }
 result += array11(nums, index + 1);
 return result;
}