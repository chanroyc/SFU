public int[] make2(int[] a, int[] b) {
/*Given 2 int arrays, a and b, returns a new array length 2 containing as
*much as it will fit, the elemtns from a followed by the elements from b.
*Must have 2 or more elemtns available between the 2 arrays.
*/
int[] results = new int[2];
if(a.length > 1)
{
results[0] = a[0];
results[1] = a[1];
}
else if(a.length > 0)
{
results[0] = a[0];
results[1] = b[0];
}
else
{
results[0] = b[0];
results[1] = b[1];
}
return results;
}