#Compiler
CC=gcc 
#Compiler Flags
CFLAGS=

#Build Executable
all: proc_parse
program: proc_parse.o
proc_parse.o: proc_parse.c 

clean:
	rm -f proc_parse proc_parse.o
run: proc_parse
	./proc_parse