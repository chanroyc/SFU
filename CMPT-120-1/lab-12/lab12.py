NUMS1 = []
N_list = []
import random
def input_N():
    N = raw_input("Enter an integer N: ")
    while N.isalpha()==True:
       N = raw_input("Enter an integer N: ")
    while N.isdigit()!=True:
        N = raw_input("Enter an integer N: ")
    N_list.append(N)
    return N

def lst():
    for i in range(N):
        num = random.randint(1, 10)
        NUMS1.append(num)
    print "List is", NUMS1

def average_deviation():
    average = float(sum(NUMS1))/float(N)
    print "Average =", average
    deviation = 0
    maxNum = max(NUMS1)
    minNum = min(NUMS1)

    deviation_max = maxNum - average
    deviation_min = average - minNum

    if deviation_max>deviation_min:
        print "Maximum Deviation =", deviation_max
    else:
        print "Maximum Deviation =", deviation_min

input_N()
N = int(N_list[0])
lst()
average_deviation()
