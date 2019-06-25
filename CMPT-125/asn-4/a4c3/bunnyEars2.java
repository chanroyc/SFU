public int bunnyEars2(int bunnies) {
/*Bunnies are number 1, 2... Odd bunnies have 2 years, even bunnies have ears. 
*Returns the number of ears given N bunnies recursively
*/
  if(bunnies == 0) {
    return bunnies;
  } else if(bunnies % 2 == 0) {
    return 3 + bunnyEars2(bunnies - 1);
  } else {
    return 2 + bunnyEars2(bunnies - 1);
  }
}