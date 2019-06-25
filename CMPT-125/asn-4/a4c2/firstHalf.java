public String firstHalf(String str) {
//Given a string of even length, returns the first half of the string
  int n = str.length();
  n = n/2;
  return str.substring(0, n);
}
