/*
 * NAME, etc.
 *
 * sync.c
 *
 */

#define _REENTRANT

#include "sync.h"


/*
 * Spinlock routines
 */

int my_spinlock_init(my_spinlock_t *mutex)
{
	if( mutex == NULL )
		return -1;
	mutex->state = 0;
	return 0;
}

int my_spinlock_destroy(my_spinlock_t *mutex)
{
/*
	if( mutex == NULL )
		return -1;
	delete mutex->state;
	delete mutex;
	return 0;
*/
}

int my_spinlock_unlock(my_spinlock_t *mutex)
{
	if( mutex->state == 1 )
	{
		mutex->state = 0;
		return 0;
	}
	return -1;
}

int my_spinlock_lockTAS(my_spinlock_t *mutex)
{
	// Spin and keep setting if locked
	if( TestandSet( mutex ) == 1 )
	{
		return my_spinlock_lockTAS( mutex );
	}
	else
	{	
		// already set state to 1 so no need to do so again here
		return 0;
	}

/* My incorrect implementation --REMOVE
	if( mutex->state == 0 )
	{
		mutex->state = 1;
		return 0;
	}
	return -1;
*/
}


int my_spinlock_lockTTAS(my_spinlock_t *mutex)
{	
	// lurk , if trylock return 1 then lock is free, if 0 then it is still locked. go to recursive call
	if( mutex->state == 1 )
	{
		return my_spinlock_lockTTAS( mutex );
	}
	else
	{
		if( TestandSet( mutex ) == 1 )
		{
			return my_spinlock_lockTTAS( mutex );
		}
		else
		{
			return 0;
		}	
	}

/*
	while( mutex->state == 1 )
	{
		continue;
	}
	my_spinlock_lockTAS;
*/
}

int my_spinlock_trylock(my_spinlock_t *mutex)
{
	// Try to read lock, if free return 1 , else return 0
	if( mutex == NULL )
		return -1;
	else if( mutex->state == 0 ) 
	{
		mutex->state = 1;
		return 0;
	}
	else
		return -1;
}

// Atomic test and set
int TestandSet(my_spinlock_t *mutex)
{
	if( mutex == NULL )
		return -1;
	int prev = mutex->state;
	mutex->state=1;
	return prev;
}



/*
 * Mutex routines
 */

int my_mutex_init(my_mutex_t *mutex)
{	
	if( mutex == NULL )
		return -1;
	mutex->state = 0;
	mutex->delay = 100;
	mutex->MAXdelay = 1000;
}

int my_mutex_destroy(my_mutex_t *mutex)
{
}

int my_mutex_unlock(my_mutex_t *mutex)
{
	if( mutex->state == 1 )
	{
		mutex->state = 0;
		return 0;
	}
	return -1;
}

int my_mutex_lockTAS(my_mutex_t *mutex)
{
	// Spin and keep setting if locked
	if( TestandSet2( mutex ) == 1 )
	{
		sleep( random() % mutex->delay );
		if( mutex->delay < mutex->MAXdelay )
		{
			mutex->delay = mutex->delay * 2;
		}
		return my_mutex_lockTAS( mutex );
	}
	else
	{	
		// already set state to 1 so no need to do so again here
		return 0;
	}
}


int my_mutex_lockTTAS(my_mutex_t *mutex)
{
	// lurk , if trylock return 1 then lock is free, if 0 then it is still locked. go to recursive call
	if( mutex->state == 1 )
	{
		return my_mutex_lockTTAS( mutex );
	}
	else
	{
		if( TestandSet2( mutex ) == 1 )
		{
			sleep( random() % mutex->delay );
			if( mutex->delay < mutex->MAXdelay )
			{
				mutex->delay = mutex->delay * 2;
			}
			return my_mutex_lockTTAS( mutex );
		}
		else
		{
			return 0;
		}
	}
	
}

int my_mutex_trylock(my_mutex_t *mutex)
{
	// Try to read lock, if free return 1 , else return 0
	if( mutex == NULL )
		return -1;
	else if( mutex->state == 0 ) 
	{
		mutex->state = 1;
		return 0;
	}
	else
		return -1;
}

// Atomic test and set
int TestandSet2(my_mutex_t *mutex)
{
	if( mutex == NULL )
		return -1;
	int prev = mutex->state;
	mutex->state=1;
	return prev;
}

