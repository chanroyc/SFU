public String seeColor(String str) {
//If the string beings with red or blue, returns that color string, otherwise returns the empty string
if(str.length() >= 3 && str.substring(0, 3).equals("red"))
{
return str.substring(0, 3);
}
else if(str.length() >= 4 && str.substring(0, 4).equals("blue"))
{
return str.substring(0, 4);
}
else
{
return "";
}
}
