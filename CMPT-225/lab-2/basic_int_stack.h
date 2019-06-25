/* File: basic_int_stack.h       

  Header file for a very basic array-based implementation of a stack.

*/

class basic_int_stack
{
  public:
    // This part should be implementation independent.
    basic_int_stack(); // constructor
    void push( int item );
    int pop(); 
    int top();
    bool empty();
    int size();

  private:
    // This part is implementation-dependant.

    // a pointer to the array which stores the stack contents.
    int *A ; 

    // capacity, the max size of the stack, will be the size of A.
    int capacity ; 

    // stack_size records the current stack size 
    // stack_size-1 will index the top of stack in the array
    int stack_size ; 
};
