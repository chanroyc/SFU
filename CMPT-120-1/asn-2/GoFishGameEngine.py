from CardTools import *
import random

#######################################################
#######################################################
################FUNCTION DEFINITIONS###################

def pBooks(player):
    print "-"*10+"BOOKS"+"-"*10
    print "-"*27
    print "-"*27
    print
    books[player].append(target_rank)
    print "Player 0:", books[0]
    print "Player 1:", books[1]
    print "Player 2:", books[2]
    print "Player 3:", books[3]
    print
    print "-"*27
    print "-"*27

def start_game():
    print("****************************************************")
    print "TURN: Player", N, "its your turn"
    print("****************************************************")

#REMOVING SUITS AND SLICING

def remove_suits():
    newhands = []
    for playerhand in pHands:
        newhand = []
        for card in playerhand:
            newcard = card[0]
            newhand.append(newcard)
        newhands.append(newhand)
    global pHands_new 
    pHands_new = newhands

def remove_suits_from_deck():
    newdeck = [] 
    for card in sDeck:
        newcard = card[0] 
        newdeck.append(newcard)
    global sDeck_new
    sDeck_new = newdeck

def slicing(player):
    global myStr
    myStr = ""
    slicing_p1(player)
    slicing_p2(player)
    slicing_assignment(player)

def slicing_p1(player):
    pHandsSlice = pHands[player]
    pHandsString = ", ".join(pHands[player])
    x = len(pHands[player])
    for i in range(x):
        y = ''.join(pHandsSlice[i])
        y = y.replace(y[1], "")
        global myStr
        myStr = myStr + y + ","
    

def slicing_p2(player):
    global myStr
    myStr = myStr[:-1]

def slicing_assignment(player):
    if player==0:
        global list0
        list0 = myStr
    elif player==1:
        global list1
        list1 = myStr
    elif player==2:
        global list2
        list2 = myStr
    elif player==3:
        global list3
        list3 = myStr

#CHOOSING TARGET

def choose_target():
    global target
    target = raw_input("Who do you want to ask (1-3)? ")

    while target.isdigit()!=True:
        print "Error: Must type a valid player id (from 1 to 3): "
        target = raw_input("Who do you want to ask (1-3?) ")
    if target.isdigit()==True:
        target = int(target)
    while target>3 or target<1:
        print "Error: Must type a valid player id (from 1 to 3): "
        target = raw_input("Who do you want to ask (1-3?) ")
        target = int(target)

def choose_target_computer():
    global target
    target = random.randint(0, 3)
    while target==N:
        target=random.randint(0,3)


def choose_rank():
    global target_rank
    print "What rank are you seeking (", pHands_new[N], ")? "
    target_rank = raw_input()
    
    while pHands_new[N].count(target_rank) == 0:
        print "Error: Must type one of the following valid single character card ranks: "
        print "What rank are you seeking (", pHands_new[N], ")? "
        target_rank = raw_input()

    print "*"*70
    print "Player", target, "is being targeted for rank <"+target_rank+">"
    print "*"*70

def choose_rank_computer():
    global target_rank
    from random import choice
    target_rank = choice(pHands_new[N])

    print "*"*70
    print "Player", target, "is being targeted for rank <"+target_rank+">"
    print "*"*70

#FISHING

def fishing():
    global target_counter
    target_counter = pHands_new[target].count(target_rank)
    global card_counter
    
    if target_counter >0:
        for i in range(target_counter):
            pHands_new[target].remove(target_rank)
        for i in range(target_counter):
            pHands_new[N].append(target_rank)
        print "*"*70
        print "HIT:", target_counter, "card(s) transferred"
        print "*"*70
        card_counter = pHands_new[N].count(target_rank)
        if card_counter ==4:
            for i in range(card_counter):
                pHands_new[N].remove(target_rank)
            pBooks(N)
    else:
        draw = GetTopCard(sDeck_new)
        if draw == target_rank:
            pHands_new[N].append(draw)
            print "HIT: LUCKILY, You fished up the rank <"+draw+">"
            card_counter = pHands_new[N].count(draw)
            if card_counter ==4:
                for i in range(card_counter):
                    pHands_new[N].remove(draw)
                pBooks(N)
                
        elif draw != target_rank:
            pHands_new[N].append(draw)
            print "MISS: You fished up the rank <"+draw+">"
            card_counter = pHands_new[N].count(draw)
            if card_counter ==4:
                for i in range(card_counter):
                    pHands_new[N].remove(draw)
                pBooks(N)


####TOP LEVEL

print("~"*70)
print("~"*25+"WELCOME TO GO FISH!"+"~"*26)
print("~"*70)


####VARIABLES ETC

nPlayers = 4
nCards = 10
deck = SetDeck()
sDeck = Shuffle(deck[:])
pHands = DealInitialCards(nPlayers,nCards,sDeck)
Sort(pHands[0])
ShowCards(0,pHands[0])
N = 0
new_N = 0
myStr = ""
myStrList = ""
Draw = ""
global books
books = [[],[],[],[]]

####GAME

slicing(0)
slicing(1)
slicing(2)
slicing(3)
remove_suits()
remove_suits_from_deck()

while len(sDeck_new)>0:
    if N ==0:
        start_game()
        choose_target()
        choose_rank()
        fishing()
        N = target
    elif N!=0:
        start_game()
        choose_target_computer()
        choose_rank_computer()
        fishing()
        N = target
max_len = len(max([books[0], books[1], books[2], books[3]], key=len))
lists = {
    "Player 0": books[0],
    "Player 1": books[1],
    "Player 2": books[2],
    "Player 3": books[3],
    }

print "\n\n"
print "-"*10+"BOOKS"+"-"*10
print "-"*27
print "-"*27
print
print "Player 0:", books[0]
print "Player 1:", books[1]
print "Player 2:", books[2]
print "Player 3:", books[3]
print
print "-"*27
print "-"*27
print "\n\n      ***Winner(s)***\n\n"
names = [name for name in lists if len(lists[name])==max_len]
print '{}'.format('\n'.join(names))
print "\n\n"
print "     CONGRATULATIONS!!\n\n     ***************"

