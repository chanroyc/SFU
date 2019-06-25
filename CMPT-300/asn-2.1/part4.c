#define _GNU_SOURCE
#include <stdio.h>
#include <stdint.h>
#include <time.h>
#include <errno.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>
#include <sched.h>

unsigned long long timespecDiff(struct timespec *timeA_p, struct timespec *timeB_p)
{
//Returns Time Specification Difference between start and stop time.
  return ((timeA_p->tv_sec * 1000000000) + timeA_p->tv_nsec) -
           ((timeB_p->tv_sec * 1000000000) + timeB_p->tv_nsec);
}


int main()
{
int p1[2], p2[2];
char msg1 = 'a';
char msg2 = 'b';
unsigned long long arrayread[10];
unsigned long long arraywrite[10];
unsigned long long sum_read = 0;
unsigned long long sum_write = 0;
unsigned long long temp1 = 0;
unsigned long long temp2 = 0;

struct timespec start1;
struct timespec stop1;
struct timespec start2;
struct timespec stop2;

unsigned long long read1;
unsigned long long write1;

/*Set Affinity to Processor 1 */
cpu_set_t proc;
CPU_ZERO(&proc);
CPU_SET(1, &proc);
sched_setaffinity(getpid(), sizeof(proc), &proc);
	
/* Create Pipes */

if (pipe(p1) != 0 || pipe(p2) !=0){
	perror("Pipe Failed");
	exit(1);
}

pid_t pid = fork();

if(pid == -1){
	perror("Fork Failed");
	exit(1);
}else if (pid == 0){

	int i;
	for(i=0;i<10;i++)
	{
	close(p1[0]);
	close(p2[1]);

	write(p1[1], &msg2, 1);
	read(p2[0], &msg2, 1);
	}
	exit(0);
}else{
	int j;
	for(j=0;j<10;j++)
	{	
	close(p1[1]);
	close(p2[0]);
	
	clock_gettime(CLOCK_MONOTONIC, &start1);
	read(p1[0], &msg1, 1);
	clock_gettime(CLOCK_MONOTONIC, &stop1);

	read1 = timespecDiff(&stop1,&start1);
	arrayread[j] = read1;
	printf("Read = %llu\n", read1);

	clock_gettime(CLOCK_MONOTONIC, &start2);
	write(p2[1], &msg1, 1);
	clock_gettime(CLOCK_MONOTONIC, &stop2);

	write1 = timespecDiff(&stop2,&start2);
	arraywrite[j] = write1;
	printf("Write = %llu\n", write1);
	}
}

/* Calculate the Average Read and Write */

int h;
for(h=0; h<10; h++)
{
	 temp1 += arrayread[h];
}
sum_read = temp1/10;

int k;
for(k=0; k<10; k++)
{
	temp2 += arraywrite[k];
}

sum_write = temp2/10;
printf("Average Read : %llu\n", sum_read);
printf("Average Write: %llu\n", sum_write);

}
