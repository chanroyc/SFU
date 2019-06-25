public int[] rotateLeft3(int[] nums) {
//Given an array of ints length 3, returns an array with the elemtns rotated left.
  int str = nums[0];
  nums[0] = nums[1];
  nums[1] = nums[2];
  nums[2] = str;
  return nums;
}
