#define max_len 80
#define max 10
#define TRUE 1
#define FALSE 0

#include "main.h"

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <stdbool.h>

void *fnC()
{
    int i;
    for(i=0;i<1000000;i++)
    {   
        c++;
    }   
}


pthread_mutex_t count_mutex;
pthread_spinlock_t count_spin;
my_spinlock_t count_msl;

void *pthreadMutexTest()
{
    int i;
    for(i=0;i<numItterations;i++)
    { 
	pthread_mutex_lock(&count_mutex);
	c++;
	pthread_mutex_unlock(&count_mutex);    
	
    }   


}

void *pthreadSpinTest()
{
	int i;
	for(i=0;i<numItterations;i++)
	{
		pthread_spin_lock(&count_spin);
		c++;
		pthread_spin_unlock(&count_spin);
	}
}

void *MSLTasTest()
{
	int i;
	for(i=0;i<numItterations;i++)
	{
		my_spinlock_lockTAS(&count_msl);
		c++;
		my_spinlock_unlock(&count_msl);
	}
}
	

int runTest(int testID)
{

/*You must create all data structures and threads for you experiments*/

if (testID == 0 || testID == 1 ) /*Pthread Mutex*/
{
	c=0;
	struct timespec start;
	struct timespec stop;
	unsigned long long result; //64 bit integer
	
	pthread_t *threads = (pthread_t* )malloc(sizeof(pthread_t)*numThreads);	
	int i;
	int rt;

	clock_gettime(CLOCK_MONOTONIC, &start);
	for(i=0;i<numThreads;i++)
	{
	
	 if( rt=(pthread_create( threads+i, NULL, &pthreadMutexTest, NULL)) )
	{
		printf("Thread creation failed: %d\n", rt);
		return -1;	
	}
	
	}
	
	for(i=0;i<numThreads;i++) //Wait for all threads to finish
	{
		 pthread_join(threads[i], NULL);
	}
	clock_gettime(CLOCK_MONOTONIC, &stop);

	printf("Threaded Run Pthread (Mutex) Total Count: %d\n", c);
	result=timespecDiff(&stop,&start);
	printf("Pthread Mutex time(ms): %llu\n",result/1000000);

}

if(testID == 0 || testID == 2) /*Pthread Spinlock*/
{
        c=0;
	struct timespec start;
	struct timespec stop;
	unsigned long long result; //64 bit integer

	pthread_t *threads = (pthread_t* )malloc(sizeof(pthread_t)*numThreads);	
	int i;
	int rt;
	
	pthread_spin_init(&count_spin, 0);	

	clock_gettime(CLOCK_MONOTONIC, &start);
	for(i=0;i<numThreads;i++)
	{
	
	 if( rt=(pthread_create( threads+i, NULL, &pthreadSpinTest, NULL)) )
	{
		printf("Thread creation failed: %d\n", rt);
		return -1;	
	}
	
	}
	
	for(i=0;i<numThreads;i++) //Wait for all threads to finish
	{
		 pthread_join(threads[i], NULL);
	}
	clock_gettime(CLOCK_MONOTONIC, &stop);
	
	pthread_spin_destroy(&count_spin);
	printf("Threaded Run Pthread (Spinlock) Total Count: %d\n", c);
	result=timespecDiff(&stop,&start);
	printf("Pthread Spinlock time(ms): %llu\n",result/1000000);


}

if(testID == 0 || testID == 3) /*MySpinlockTAS*/
{
	printf("MySpinlockTAS not working.\n");
}

if(testID == 0 || testID == 4)
{
	printf("MySpinlockTTAS not working.\n");
}

if(testID ==0 || testID == 5)
{
	printf("MyMutexTAS not working.\n");
}

if(testID == 0 || testID == 6)
{
	printf("MyMutexTTAS not working.\n");
}
/*....you must implement the other tests....*/

	return 0;
}

/*int testAndSetExample()
{
volatile long test = 0; //Test is set to 0
printf("Test before atomic OP:%d\n",test);

tas(&test);
printf("Test after atomic OP:%d\n",test);
}*/


int processInput(int argc, char *argv[])
{
char input[max_len], *sp;
const char *delim = " \t\n";
bool i_det = FALSE;
bool d_det = FALSE;
bool t_det = FALSE;
int i_pos = 0;
int d_pos = 0;
int t_pos = 0;

/*testid: 0=all, 1=pthreadMutex, 2=pthreadSpinlock, 3=mySpinLockTAS, 4=mySpinLockTTAS, 5=myMutexTAS, 6=myMutexTTAS*/
	/*You must write how to parse input from the command line here, your software should default to the values given below if no input is given*/
	
	numThreads=4;
	numItterations=1000000;
	testID=0;

	

	printf("\nPlease enter testid: ");
	if (fgets(input, sizeof(input), stdin) == NULL) {
		exit(0);
	}else{
		sp = input;
		for(argc = 0; argc<max; argc++){
			if((argv[argc] = strtok(sp, delim)) == NULL)
				break;
			if(strcmp(argv[0], "exit") == 0){
				exit(0);
			}
			
			if(strcmp(argv[argc], "i") == 0){
				i_det = TRUE;
				i_pos = argc + 1;
			}
			if(strcmp(argv[argc], "d") == 0){
				d_det = TRUE;
				d_pos = argc + 1;
			}
			if(strcmp(argv[argc], "t") == 0){
				t_det = TRUE;
				t_pos = argc + 1;
			}
				
			sp = NULL;
		
		
		}
	
	if(strcmp(argv[0], "1") == 0){
		testID = 1;
	}
	if(strcmp(argv[0], "2") == 0){
		testID = 2;
	}
	if(strcmp(argv[0], "3") == 0){
		testID = 3;
	}
	if(strcmp(argv[0], "4") == 0){
		testID = 4;
	}
	if(strcmp(argv[0], "5") == 0){
		testID = 5;
	}
	if(strcmp(argv[0], "6") == 0){
		testID = 6;
	}
	if(strcmp(argv[0], "0") == 0){
		testID = 0;
	}
	
	sp = NULL;
	}
	if(i_pos != 0)	
		numItterations = atoi(argv[i_pos]);
	if(d_pos != 0)
		testID = atoi(argv[d_pos]);
	if(t_pos != 0)
		numThreads = atoi(argv[t_pos]);
	
	return 0;
}


int main(int argc, char *argv[])
{


	printf("\nUsage of: %s -t #threads -i #itterations -d testid\n\n", argv[0]);
	printf("testid: 0=all\ntestid: 1=pthreadMutex\ntestid: 2=pthreadSpinlock\n");
	printf("testid: 3=mySpinLockTAS\ntestid: 4=mySpinLockTTAS\ntestid: 5=myMutexTAS\ntestid: 6=myMutexTTAS\n");	
	printf("\nEnter 'exit' to quit.\n");
	
	//testAndSetExample(); //Uncomment this line to see how to use TAS
	
	processInput(argc,argv);
	runTest(testID);
	return 0;

}
