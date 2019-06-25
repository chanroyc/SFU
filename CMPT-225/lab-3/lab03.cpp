#include <iostream>
#include "basic_int_stack.h"
using namespace std;

    int memory_peek(int *a, int j)
{
	for(int i=0; i<j; i++)
{
	cout<< &a;
	a++;
}
}
	
void main()
{
    int array1[2] = { 1111111, 2222222 };
    cout << "array1 is at address " << array1 << endl;
    cout << "peeking at array1" << endl;
    memory_peek( array1-10, 20 );

    basic_int_stack stack_1;
    stack_1.push(5555555);
    stack_1.push(6666666);
    cout << "stack_1 is at address " << stack_1 << endl;
    cout << "peeking at stack_1" << endl; 
    memory_peek( ((int*)stack_1)-10, 20 );

    int * array2 = new int[2]; 
    array2[0] = 3333333;
    array2[1] = 4444444;
    cout << "array2 is at address " << array2 << endl;
    cout << "peeking at array1" << endl;
    memory_peek( array2-10, 20 );

    basic_int_stack * stack_2 = new basic_int_stack();
    stack_2->push(7777777);
    stack_2->push(8888888);
    cout << "stack_2 is at address " << stack_2 << endl;
    cout << "peeking at stack_2" << endl;
    memory_peek( ((int*)stack_2)-10, 20 );

    cout << "the difference between array1 and array2 is " <<  (array1 - array2) << endl;
    cout << "the difference between stack_1 and stack_2 is " <<  (stack_1 - stack_2) << endl;
    cout << "the difference between array1 and stack_1 is " <<  (array1 - stack_1) << endl;
 
    int * array3 = array2;
    array3[0] = 121212; 
    array3[1] = 232323;
    cout << "array2 now contains [" << array2[0] << array2[1] << "]" << endl;

    basic_int_stack * stack_3 = stack_2;
    cout << "popping the top elements of stacks 2 and 3" < endl;
    cout << stack_3->pop() << endl;
    cout << stack_2->pop() << endl;
}
