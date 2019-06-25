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

int main()
{
struct timespec start;
struct timespec stop;
unsigned long long result; //64 bit integer

/*
-----REALTIME CLOCK-----

>>Provides access to the system-wide realtime clock. 
>>Values are dynamic and when user changes system time, so will this.

----------USES----------

>>Measures system-wide time.
>>"Time-of-day" time.
*/
clock_gettime(CLOCK_REALTIME, &start); /* Mark the start time.*/
sleep(1); /* Do stuff */
clock_gettime(CLOCK_REALTIME, &stop); /* Mark the stop time.*/

result=timespecDiff(&stop,&start);

printf("CLOCK_REALTIME Measured: %llu\n",result);

/*
-----MONOTONIC CLOCK-----

>>Absolute elapsed wall-clock time since a fixed point.
>>Not affected by ""time-of-day"" clock.
----------USES----------
>>Measures elapsed time.
>>Measure elapsed time between two events.
*/

clock_gettime(CLOCK_MONOTONIC, &start); /* Mark the start time.*/
sleep(1); /* Do stuff */
clock_gettime(CLOCK_MONOTONIC, &stop); /* Mark the stop time.*/

result=timespecDiff(&stop,&start);

printf("CLOCK_MONOTONIC Measured: %llu\n",result);

/*
-----CPU TIME CLOCK-----

>>High resolution timer provided by CPU for each process.
>>Time spent waiting (sleeping process) is not counted.

----------USES----------

>>Measures the CPU time consumed by a process.
*/

clock_gettime(CLOCK_PROCESS_CPUTIME_ID, &start); /* Mark the start time.*/
sleep(1); /* Do stuff */
clock_gettime(CLOCK_PROCESS_CPUTIME_ID, &stop);

result=timespecDiff(&stop,&start);

printf("CLOCK_PROCESS_CPUTIME_ID Measured: %llu\n",result);

/*
--CPU THREAD TIME CLOCK--

>>High resolution timer provided by CPU for each thread.
>>Time spent waiting on threads is not counted.

----------USES----------

>>Measures CPU time consumed by a thread.
*/

clock_gettime(CLOCK_THREAD_CPUTIME_ID, &start); /* Mark the start time.*/
sleep(1); /* Do stuff */
clock_gettime(CLOCK_THREAD_CPUTIME_ID, &stop); /* Mark the stop time.*/

result=timespecDiff(&stop,&start);

printf("CLOCK_THREAD_CPUTIME_ID Measured: %llu\n",result);
}


