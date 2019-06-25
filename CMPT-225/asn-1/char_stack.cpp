/* File: char_stack.cpp

Implementation of functions for basic simple array-based implementation of a stack.

*/

#include "char_stack.h"// contains the declarations of the variables and functions.

char_stack::char_stack(){
	// the default constructor intitializes the private variables.
	capacity = 100;
	A = new int[capacity];
	stack_size = 0;
}

void char_stack::push(int item){
	A[stack_size] = item;
	stack_size = stack_size + 1;
}

int char_stack::top(){
	return A[stack_size - 1];
}

int char_stack::pop(){
	stack_size = stack_size - 1;
	return A[stack_size];
}

bool char_stack::empty(){
	return stack_size == 0;
}