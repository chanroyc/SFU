A = int(raw_input("Please input a positive integer A: "))
B = int(raw_input("Please input another positive integer B: "))

##Store Initial input of positive integer A for later use
multiples = A

##Multiples of A that are less than B are

print "Multiples of A that are less than B are: "
while A<B:
    print A
    A = A + multiples

##The sum of these multiples

sum_multiples = 0
for i in range(multiples, A, multiples):
    sum_multiples = sum_multiples+i
print "Sum of these multiples:", sum_multiples
