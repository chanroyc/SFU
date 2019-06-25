public int[] fizzArray(int n) {
/*Given a number n, creats and returns a new int array of length n, containing
*the numbers 0, 1, 2,....n-1. The given n may be zero, in which case returns a length 0 array.
*/
   int count = 0;
   int[] myIntArray = new int[n];
   while(count<n){
   myIntArray[count] = count;
   count++;
   }
   return myIntArray;
}