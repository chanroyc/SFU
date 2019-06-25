first_source = int(raw_input("Please Enter Income from Source 1: "))
second_source = int(raw_input("Please Enter Income from Source 2: "))

if first_source>second_source:
    print "Your Primary Income Source Generates", first_source
else:
    print "Your Primary Income Source Generates", second_source

if first_source>second_source:
    primary_income = first_source
else:
    primary_income = second_source

if primary_income>0 and primary_income<10000:
    print "You are expected to pay $0 as Tax for the current year."
elif primary_income>10001 and primary_income<20000:
    x = primary_income*0.1
    print "You are expected to pay $", x, "as Tax for the current year."
elif primary_income>20001 and primary_income<30000:
    x = 3000 + primary_income*0.25
    print "You are expected to pay $", x, "as Tax for the current year."
elif primary_income>30001 and primary_income<=70000:
    x = 10000 + primary_income*0.45
    print "You are expected to pay $", x, "as Tax for the current year."
elif primary_income>70000:
    x = 30000 + primary_income*0.5
    print "You are expected to pay $", x, "as Tax for the current year."
