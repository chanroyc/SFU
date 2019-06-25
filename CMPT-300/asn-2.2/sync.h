/*
 * NAME, etc.
 *
 * sync.h
 */

#ifndef _my_SYNC_H_
#define _my_SYNC_H_

#include "atomic_ops.h"
#include <stdio.h>
#include <stdlib.h>
#include <stddef.h>
#include <pthread.h>
#include <stdint.h>


struct my_mutex_struct {
  /* FILL ME IN! */
	int state; // 0 being unlocked, 1 being locked
	int delay; // the time delay lock is backed off for
	int MAXdelay; // max delay for lock
};



typedef struct my_mutex_struct my_mutex_t;


int my_mutex_init(my_mutex_t *mutex);
int my_mutex_unlock(my_mutex_t *mutex);
int my_mutex_destroy(my_mutex_t *mutex);

int my_mutex_lockTAS(my_mutex_t *mutex);
int my_mutex_lockTTAS(my_mutex_t *mutex);
int my_mutex_trylock(my_mutex_t *mutex);



/*Spinlock Starts here*/

struct my_spinlock_struct {
  /* FILL ME IN! */
	int state; // 0 being unlocked, 1 being locked
};

typedef struct my_spinlock_struct my_spinlock_t;

int my_spinlock_init(my_spinlock_t *lock);
int my_spinlock_destroy(my_spinlock_t *lock);
int my_spinlock_unlock(my_spinlock_t *lock);

int my_spinlock_lockTAS(my_spinlock_t *lock);
int my_spinlock_lockTTAS(my_spinlock_t *lock);
int my_spinlock_trylock(my_spinlock_t *lock);
int my_spinlock_TestandSet(my_spinlock_t *mutex);


#endif
