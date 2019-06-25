#include "queue.h"
#include <iostream>
using namespace std;

queue::queue()
{
	front_p = 0;
	back_p = 0;
	current_size = 0;
}

void queue::enqueue(int item)
{
	back_p = new node(item, back_p);
	current_size++;
	front_p = back_p;
	for (int i = 0; i < current_size - 1; i++)
		front_p = front_p->next;
}

int queue::dequeue()
{
	int info;
	node *temp = back_p;
	for (int i = 0; i < current_size-1; i++)
		temp = temp->next;
	info = temp->data;
	temp->data = NULL;
	current_size--;

	front_p = back_p;
	for (int i = 0; i < current_size - 1; i++)
		front_p = front_p->next;
	return info;
}

int queue::front()
{
	int front = front_p->data;
	return front;
}

bool queue::empty()
{
	return current_size == 0;
}

int queue::remove(int item)
{
	int occ = 0;
	node *pointer = back_p;
	node *temp = back_p;
	//Check if the last enqueued item is 'item'
	if (pointer->data == item)
	{
		pointer->data = NULL;
		pointer = pointer->next;
		temp = temp->next;
		occ++;
	}
	
	//Sets all 'item's to NULL first and count the number of occurences
	for (int q = 0; q < current_size - 1; q++)
	{
		if (pointer->data == item)
		{
			pointer->data = NULL;
			pointer = pointer->next;
			occ++;
		}
		else
		{
			pointer = pointer->next;
		}
	}
	//Pointer reset back to the last enqueued item;
	pointer = back_p;
	temp = back_p;

	//Shift contents in the queue, counter for number of items traversed
	int counter = 0;
	int pos = 0;
	int reset = 0;
	int counter_2 = 0;
	//Check if last items of the queue are a set of NULLs
	while (pointer->data == NULL)
	{
		pointer = pointer->next;
		temp = temp->next;
		current_size--;
	}
	for (int i = 1; i < current_size; i++)
	{
		if (pointer->data != NULL)
		{
			pointer = pointer->next;
			counter++;
			reset++;
			pos++;
			counter_2++;
		}
		else
		{
			//Loop to shift each individual item back into place
			while (reset > 0)
			{
				for (int j = 1; j < counter; j++)
				{
					temp = temp->next;
				}
				pointer->data = temp->data;
				temp->data = NULL;
				temp = back_p;
				pointer = back_p;
				for (int k = 0; k < counter_2; k++)
				{
					pointer = pointer->next;
				}
				counter--;
				counter_2--;
				reset--;
			}
			pointer = back_p;
			for (int l = 0; l < pos; l++)
				pointer = pointer->next;		
		}
	}
	//Return number of occurences
	return occ;
}