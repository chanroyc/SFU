#include <stdio.h>
#include <stdint.h>
#include <time.h>
#include <errno.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include <sys/types.h>

unsigned long long timespecDiff(struct timespec *timeA_p, struct timespec *timeB_p)
{
//Returns Time Specification Difference between start and stop time.
  return ((timeA_p->tv_sec * 1000000000) + timeA_p->tv_nsec) -
           ((timeB_p->tv_sec * 1000000000) + timeB_p->tv_nsec);
}

void something();

int main()
{
struct timespec start;
struct timespec stop;
unsigned long long result; //64 bit integer


clock_gettime(CLOCK_MONOTONIC, &start); /* Mark the start time.*/
something();
clock_gettime(CLOCK_MONOTONIC, &stop); /* Mark the stop time.*/

result=timespecDiff(&stop,&start);

printf("Cost of Minimal Function call: %llu\n",result);

}

void something(){
getpid();
return;
}

