public int factorial(int n) {
//Given n of 1 or more, returns factorial of n
  if(n == 1) {
    return n;
  }
  return n * factorial(n - 1);
}