#Compiler
CC=gcc $(CFLAGS)
#Compiler Flags
CFLAGS= -lpthread -pthread

#Build Executable
all: part2 part3 part4 part5

part2: part2.o
part3: part3.o
part4: part4.o
part5: part5.o

part2.o: part2.c
part3.o: part3.c
part4.o: part4.c
part5.o: part5.c

clean:
	rm -f part2 part2.o
	rm -f part3 part3.o
	rm -f part4 part4.o
	rm -f part5 part5.o
