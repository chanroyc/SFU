public String left2(String str) {
//Given a string, returns a rotated left 2 version where the first 2 chars are moved to the end
  int n = str.length();
  if (n<2){
    return str;
  }
  String front = str.substring(0,2);
  String back = str.substring(2, n);
  return back+front;
}
