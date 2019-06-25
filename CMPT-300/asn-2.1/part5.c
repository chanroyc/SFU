#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <stdint.h>
#include <time.h>
#include <sched.h>

unsigned long long timespecDiff(struct timespec *timeA_p, struct timespec *timeB_p)
{
  return ((timeA_p->tv_sec * 1000000000) + timeA_p->tv_nsec) -
           ((timeB_p->tv_sec * 1000000000) + timeB_p->tv_nsec);
}

struct timespec start;
struct timespec stop;
unsigned long long result;
int num = 0;

pthread_mutex_t count_mutex;

void *lock()
{
    pthread_mutex_lock(&count_mutex);
    clock_gettime(CLOCK_MONOTONIC, &stop);
    result = timespecDiff(&stop,&start)/100;
    printf("Thread Switch Time : %llu\n", result);
    printf("Value of Num: %d\n", num);
    if (num == 0){
		num = 1;
		pthread_mutex_unlock(&count_mutex);
		clock_gettime(CLOCK_MONOTONIC, &start);
    }else{
		num = 0;
		pthread_mutex_unlock(&count_mutex);	
		clock_gettime(CLOCK_MONOTONIC, &start);
    }   
}

void main()
{
/*Set Affinity to Processor 1 */
cpu_set_t proc;
CPU_ZERO(&proc);
CPU_SET(1, &proc);
sched_setaffinity(getpid(), sizeof(proc), &proc);

int rt1, rt2, rt3, rt4, rt5, rt6, rt7, rt8, rt9, rt10;
pthread_t t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;

    /* Create 2 threads */
if( (rt1=pthread_create( &t1, NULL, &lock, NULL)) )
	printf("Thread creation failed: %d\n", rt1);
if( (rt2=pthread_create( &t2, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt2);
/*

if( (rt3=pthread_create( &t3, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt3);
if( (rt4=pthread_create( &t4, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt4);
if( (rt5=pthread_create( &t5, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt5);
if( (rt6=pthread_create( &t6, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt6);
if( (rt7=pthread_create( &t7, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt7);
if( (rt8=pthread_create( &t8, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt8);
if( (rt9=pthread_create( &t9, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt9);
if( (rt10=pthread_create( &t10, NULL, &lock, NULL)) )
        printf("Thread creation failed: %d\n", rt10);
*/

    /* Wait for all threads to finish */
    pthread_join( t1, NULL);
    pthread_join( t2, NULL);
/*  pthread_join( t3, NULL);
    pthread_join( t4, NULL);
    pthread_join( t5, NULL);
    pthread_join( t6, NULL);
    pthread_join( t7, NULL);
    pthread_join( t8, NULL);
    pthread_join( t9, NULL);
    pthread_join( t10, NULL);
    
*/ 
	pthread_mutex_destroy(&count_mutex);
    

}
