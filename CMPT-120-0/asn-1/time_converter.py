###  CMPT 120 - D100
###  authors: Roy Chan, Helen Xiaoying Chen
###  assignment #1 (creating a time converter)
###  Date: September 20, 2012

# FUNCTION DEFINITIONS

def convert_ab ():
    day = input("Please provide a number of days (no fractions): ")
    hour = input("Please provide a number of hours (no fractions): ")
    min = input("Please provide a number of minutes (no fractions): ")
    total_min = day*1440 + hour*60 + min
    print "\nThis is equivalent to %d minutes." % total_min
    
def convert_ba ():
    min = input("Please provide a number of minutes (no fractions): ")
    total_day = min/1440
    total_hour = (min%1440)/60
    total_min = (min%1440)%60
    print "\nThis is equivalent to %d days, %d hours, and %d minutes." % (total_day,total_hour,total_min)

def do_end_1 ():
    print "\nEnd."

def do_end_2 ():
    print "Good bye!"

    
# TOP LEVEL

print "Welcome to our time converter. \nHere you can convert between formats (a) and (b). \n\nFormat (a): days, hours, minutes \nFormat (b): minutes \n "

convert = raw_input("If you would like to convert from format (a) to (b), type ab. Otherwise, type ba: ")

if (convert == "ab"):
    convert_ab()
    do_end_1 ()
    
if (convert == "ba"):
    convert_ba()
    do_end_1 ()
else:
    do_end_2 ()

# END
