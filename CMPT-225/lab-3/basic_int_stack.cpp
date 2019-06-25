/* File: basic_int_stack.cpp

  Implementation of functions for basic simple array-based implementation of a stack.

*/

#include "basic_int_stack.h"// contains the declarations of the variables and functions.

basic_int_stack::basic_int_stack(){
  // the default constructor intitializes the private variables.
  capacity = 100;
  A = new int[capacity];
  stack_size = 0;
} 

void basic_int_stack::push( int item ){
  A[stack_size] = item ;
  stack_size = stack_size + 1;
}

int basic_int_stack::top(){
  return A[stack_size-1];
}

int basic_int_stack::pop(){
  stack_size = stack_size - 1 ;
  return A[ stack_size ];
}


bool basic_int_stack::empty(){
  return stack_size == 0 ; 
}

