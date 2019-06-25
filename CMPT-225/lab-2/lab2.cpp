#include <iostream>
#include "basic_int_stack.h"
using namespace std;

basic_int_stack::basic_int_stack(){
  // the default constructor intitializes the private variables.
  capacity = 100;
  A = new int[capacity];
  stack_size = 0;
} 

void basic_int_stack::push(int item){
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


int basic_int_stack::size(){
	return stack_size;
}

int main()
{
	cout << "Roy Chan\n";
	cout << "chanroyc\n";
	cout << "301202770\n";

	basic_int_stack myStack;	
	
	int x=0;
	int sum = 0;
	int top = 0;
	cout<< "Please enter a positive integer (negative to stop):";
	cin >> x;	
	sum+=x;
	while(x>=0)
	{
	myStack.push(x);
	cin >> x;	
	if(x>0)
	{
		sum+=x;
	}
	}
	cout<< "Length of the sequence:" << myStack.size() <<"\n";
	cout<< "Sum of the sequence:" << sum<<"\n";
	while(myStack.size()>0)
	{
		top = myStack.top();
		myStack.pop();
		cout<< top <<"\n";
	}
	cout<< x <<"\n";
	cout<< "Goodbye.";

}

	
	
	
	




