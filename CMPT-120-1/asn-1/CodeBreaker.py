print "\t\t\t***Welcome to Code Breaker***\n"

rounds = int(raw_input("How many rounds do you want to play (has to be a positive integer)? "))
while rounds<=0:
    rounds = int(raw_input("ERROR: How many rounds do you want to play (has to be a positive integer)? "))

roundCounter = 1
points1 = 0
points2 = 0

while roundCounter<rounds+1:
    points1 = int(points1)
    points2 = int(points2)
    print "Round "+str(roundCounter)+":"+"***Player 1's turn to setup the game.***"
    print "Player 2 look away PLEASE!"
    word = str(raw_input("Type in the secret word, QUICKLY? "))
    word = str(word.lower())
    guessesAllowed = int(raw_input("How many guesses will you allow? "))
    print "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
    print "Player 2's turn to crack the secret. "
    state = "*" * len(word)
    tries = 0
    state = "*" * len(word)
    play = True
    while play:
        if tries == guessesAllowed:          
            final1 = final1.replace("*", "")
            points1 = str(points1)
            points2 = str(len(final1)+points2)
            print "Round "+str(roundCounter)+" Score Update:"
            print "Player 1: "+points1
            print "Player 2: "+points2
            play = False
            break
        guess = raw_input("Guess a letter(a-z)?: ")
        while guess.isalpha()!= True:
            guess = raw_input("ERROR: Guess a letter (a-z)?: ")
        tries +=1
        state = list(state)
        for i in range(len(word)):
            if word[i] == guess:
                 state[i] = guess
        
        final1 = "".join(state)
        print final1
        
        if final1 == word:  
            final1 = final1.replace("*", "")
            points1 = str(points1)
            points2 = str(len(final1)+points2)
            print "Round "+str(roundCounter)+" Score Update: "
            print "Player 1: "+points1
            print "Player 2: "+points2
            play = False

    points1 = int(points1)
    points2 = int(points2)
    print "Round "+str(roundCounter)+":"+"***Player 2's turn to setup the game.***"
    print "Player 1 look away PLEASE!"
    word = str(raw_input("Type in the secret word, QUICKLY? "))
    word = str(word.lower())
    guessesAllowed = int(raw_input("How many guesses will you allow? "))
    print "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
    print "Player 1's turn to crack the secret. "
    state = "*" * len(word)
    tries = 0
    state = "*" * len(word)
    play = True
    while play:
        if tries == guessesAllowed:
            final2 = final2.replace("*", "")
            points1 = str(len(final2)+points1)
            points2 = str(points2)
            print "Round "+str(roundCounter)+" Score Update:"
            print "Player 1: "+points1
            print "Player 2: "+points2
            play = False
            break
        guess = raw_input("Guess a letter(a-z)?: ")
        while guess.isalpha()!= True:
            guess = raw_input("ERROR: Guess a letter (a-z)?: ")
        tries +=1
        state = list(state)
        for i in range(len(word)):
            if word[i] == guess:
                 state[i] = guess
        
        final2 = "".join(state)
        print final2
        
        if final2 == word:  
            final2 = final2.replace("*", "")
            points1 = str(len(final2)+points1)
            points2 = str(points2)
            print "Round "+str(roundCounter)+" Score Update:"
            print "Player 1: "+points1
            print "Player 2: "+points2
            play = False

    roundCounter = roundCounter+1

points1 = int(points1)
points2 = int(points2)
if points1>points2:
    print "Player 1 Wins!!!"
elif points1==points2:
    print "It's a DRAW!!!"
elif points1<points2:
    print "Player 2 Wins!!!"




