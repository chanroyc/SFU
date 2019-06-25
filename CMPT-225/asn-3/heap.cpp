/***********************************************************
   heap.cpp -- Implementation File for Basic Heap-of-Ints
************************************************************/
#include "heap.h"
#include <stdlib.h>
#include <math.h>

// Constructors and Destructor

Heap::Heap(void){ // New empty Heap with default capacity.
   h_capacity = 10;
   A = new int[h_capacity];
   h_size = 0;
}

Heap::Heap(int c){ // New empty Heap with capacity c.
	A = new int[c];
	h_capacity = c;
	h_size = 0;
}

Heap::Heap(int * B, int s, int c){ // New Heap with capacity c containing first s elements of B.
	A = new int[c];
	h_capacity = c;

	for (int i = 0; i < s; i++){
		A[i] = B[i];
	}
	h_size = s;
}

Heap::Heap( const Heap & H ){ // Copy constructor.
	h_capacity = H.h_capacity;
	h_size = H.h_size;

	A = new int[h_capacity];

	for (int i = 0; i < h_size; i++)
	{
		A[i] = H.A[i];
	}
}

// Destructor
Heap::~Heap(){
   delete[] A;
}


// Operators

Heap Heap::operator+( const Heap & Right_H) const { 
   // New Heap with combined contents and size of operands.
   int new_capacity = h_capacity + Right_H.h_capacity ;
   Heap New_H( new_capacity );
   
   for (int i = 0; i<h_capacity; i++){
	   New_H.insert(A[i]);
   }

  return New_H ;
}

// Modifiers

void Heap::insert(int x){
// Inserts x into the heap.
   A[h_size] = x;
   trickle_up(h_size);
   h_size ++;
}

// Repairs the heap ordering invariant after adding a new element.
// Initial call should be trickle_up(h_size-1).
void Heap::trickle_up(int v){
	int parent;
	int swap;
	if (v % 2 == 0){
		swap = v - 1;
		parent = (v / 2) - 1;
	}
	else{
		swap = v;
		parent = floor(v / 2);
	}
	if (A[v] < A[v + 1])
		swap = A[v + 1];
	if (A[parent]>0 && A[swap] > A[parent]){
		int temp = A[parent];
		A[parent] = A[swap];
		A[swap] = temp;
		swap = v - 2;
		trickle_up(swap);
	}
}

// Removes and returns minimum element.
int Heap::extract_min(){
   int temp = A[0];
   A[0] = A[--h_size];
   trickle_down(0);   
   return temp;
}

// Repairs the heap ordering invariant after replacing the root.
// Normal initial call should be trickle_down(0).
// trickle_down(i) performs the repair on the subtree rooted a A[i].
// make_heap() call trickle_down(i) for i (h_size/2)-1 down to 0.
void Heap::trickle_down(int i){
   // Complete this. N = h_size
	int temp;
	int swap = 2 * i + 1;
	if ((2 * i + 1) < h_size){
		if ((2 * i + 1) < h_size && A[2 * i + 2] < A[2 * i + 1]){
			swap = 2 * i + 2;
		}
		if (A[i] > A[swap]){
			temp = A[i];
			A[i] = A[swap];
			A[swap] = temp;
			trickle_down(swap);
		}
	}
}

// Turns A[0] .. A[size-1] into a heap.
void Heap::make_heap(){
   for( int i = (h_size/2)-1; i>=0 ; i-- ) trickle_down(i);  
}

// Prints contents of heap to standard output (for testing).
void Heap::display(){
     for(int i = 0; i < h_size ; ++i) cout << A[i] << ", " ;
}
