// Filename: gscheck.cpp

#include "char_stack.h"
#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{
	char c, l, r;
	char filename[100];
	int pos = 0;
	ifstream textfile;
	cin.getline(filename, 100);

	if (!textfile.is_open())
	{
		exit(EXIT_FAILURE);
	}

	char_stack S;

	while (textfile.good())
	{
		textfile >> c;
		pos++;
			if (c == '(' || c == '[' || c == '{')
			{
				S.push(c);
			}

			if (c == ')' || c == ']' || c == '}' )
			{
				if (S.empty())
				{
					cerr << "Too many " << c << endl;
					break;
				}
				l = S.pop();
				if (c == '{' && l != '}' || c == '(' && l != ')' || c == '[' && l != ']')
				{
					if (c == '{')
						r = '}';
					if (c == '(')
						r = ')';
					if (c == '[')
						r = ']';
					cerr << "Read " << c << ", expected " << r << endl;
					break;
				}

			}
	}

	if (!S.empty())
	{
		c = S.pop();
		cerr << "Too many " << c << endl;
	}
	cerr << "No Errors Found" << endl;
	return 0;
}

