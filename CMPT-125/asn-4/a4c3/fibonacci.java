public int fibonacci(int n) {
/*
*The fibonacci sequence contains a recursive definition. The first two values in the sequence are
*0 and 1. Each subsequent value is the sum of the previous two values. Returns the number at position n.
*/
  if(n == 1 || n == 0) {
    return n;
  }
  return fibonacci(n - 1) + fibonacci(n - 2);
  
}