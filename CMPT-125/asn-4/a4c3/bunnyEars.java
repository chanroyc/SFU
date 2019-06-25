public int bunnyEars(int bunnies) {
//Calculates total number of ears across all the bunnies recursively.
  if(bunnies == 0) {
    return 0;
  }
  return 2 + bunnyEars(bunnies - 1);
}