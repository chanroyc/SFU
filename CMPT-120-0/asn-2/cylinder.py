#### Cmpt 120 - Assignment #2
#### Authors: Roy Chan, Helen Xiaoying Chen
#### Assignment #2 (Pretty Print and Cylinder Volume)
#### Date: September 28, 2012


# FUNCTIONS DEFINITIONS

def welcome_msg1():
    print "************************** Welcome to assignment #2! ***************************"
    print " "
    print " "

def welcome_msg2():
    print " "
    dear_user = "Dear " + name
    print dear_user
    print "=" * len(dear_user)
    print "\nHere is the information that you will need..."
    print " "

def first_cylinder():
    print "FIRST CYLINDER"
    print " "
    radius = 1.1
    height = 2.2
    volume = math.pi * radius**2 * height
    print "The volume is: ",volume
    print "Where the radius is: ",radius
    print "and the height is: ",height
    print " "

def second_cylinder():
    print "SECOND CYLINDER"
    print " "
    print "Intermediate calculations: "
    radius_2 = math.sqrt(age)
    print "Radius (Square root age)is:",radius_2
    num_1 = random.randint(1, age)
    print "Random number between 1 and age is:", num_1
    num_2 = str(address)[0]
    print "First number in the address is:", num_2
    address_count = len(address)
    last_letter = address[address_count-1]
    num_3 = address.count(last_letter)
    print "Number of times last letter in address is:",num_3
    height_2 = (float(num_1) + float(num_2) + float(num_3))/3
    print "Height (average of the last three values is:",height_2
    volume_2 = math.pi * radius_2**2 * height_2
    print "The volume is: ",volume_2
    
# TOP LEVEL
welcome_msg1()
name = raw_input("Your name: ")
age = input("Your age: ")
address = raw_input("Your address (type the street number first): ")

welcome_msg2()

import math
first_cylinder()

import random
second_cylinder()

print "\nBye Bye"

