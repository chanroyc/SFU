def program(myList, number):
    count = 0
    for i in myList:
        if number==i:
            count+=1
    print search_value, "occurs", count, "times."

import random
mylist = []
N = int(raw_input("Enter a value for N: "))
for i in range(N):
    x = random.randint(-10, 10)
    mylist.append(x)
print "List: ", mylist
search_value = int(raw_input("Enter Search Value: "))
program(mylist, search_value)
