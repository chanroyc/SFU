#include "Seq.h"
#include <iostream>
using namespace std;

int main() {
   cout << "!!!Hello World!!!" << endl; // prints !!!Hello World!!!
   cout << endl << "-----Testing type <INT>." << endl << endl;
   Seq<int> s;      
   s.add(5);
   s.display();
   cout << endl;
   s.add(6);
   s.insertAt(7, 1);
   s.display();
   cout << endl;
   s.remove(6);
   s.display();
   cout << endl;

   Seq<string> t;
   cout << endl << "-----Testing type <STRING>." << endl << endl;
   t.add("!!!Hello World!!!");
   t.display();
   cout << endl;
   t.add("!!!Bye World!!!");
   t.insertAt("!!! This is the end of the world!!!", 1);
   t.display();
   cout << endl;
   t.remove("!!!Hello World!!!");
   t.display();
   cout << endl;

   Seq<float> u;
   cout << endl << "-----Testing type <FLOAT>." << endl << endl;
   u.add(5.078);
   u.display();
   cout << endl;
   u.add(6.954);
   u.insertAt(7.456, 1);
   u.display();
   cout << endl;
   u.remove(6.954);
   u.display();
   cout << endl << endl;

   return 0;
}
