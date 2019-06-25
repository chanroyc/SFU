#include <stdio.h>
#include <stdlib.h>
#include <linux/unistd.h>
#include <sys/syscall.h>

#define _prinfo_ 328

struct prinfo {
	long state; /* current state of process */
	long nice; /* process nice value */
	pid_t pid; /* process id (input) */
	pid_t parent_pid; /* process id of parent */
	pid_t youngest_child_pid; /* process id of youngest child */
	pid_t younger_sibling_pid; /* pid of the oldest among younger siblings */
	pid_t older_sibling_pid; /* pid of the youngest among older siblings */
	unsigned long start_time; /* process start time */
	long user_time; /* CPU time spent in user mode */
	long sys_time; /* CPU time spent in system mode */
	long cutime; /* total user time of children */
	long cstime; /* total system time of children */
	long uid; /* user id of process owner */
	char comm[16]; /* name of
	program executed */
};

int main(int argc, char *argv[])
{
        struct prinfo* info;
        int result;
        int test;
        pid_t pid;
        info = (struct prinfo* )malloc(sizeof(struct prinfo));
        printf("Enter 1 for testing current pid or 2 for your desired pid: ");
        scanf("%d", &test);
        if( test == 1 ) {
        	pid = getpid();
        }
        else if( test == 2 ) {
        	printf("Enter your desired pid: ");
        	scanf("%d", &pid);
        }
        if( info != NULL ) {
        	info->pid = pid;
        }
        printf("\nDiving to kernel level\n");
        result = syscall(_prinfo_, info);
        if( result != 0 ) {
        	if( result == 22 ) {
        		printf("error: EINVAL\n");
        		return 1;
        	}
        	else {
        		printf("error");
        		return 1;
        	}
        }
        printf("Rising to user level\n\n");

        printf("Current state of process: %ld\n", info->state);
        printf("Process' nice value: %ld\n", info->nice);
        printf("Process ID: %d\n", info->pid);
        printf("Process ID of parent: %d\n", info->parent_pid);
        printf("Process ID of youngest child: %d\n", info->youngest_child_pid);
        printf("Process ID of oldest among younger siblings: %d\n", info->younger_sibling_pid);
        printf("Process ID of youngest among older siblings: %d\n", info->older_sibling_pid);
        printf("Process start time: %ld\n", info->start_time);
        printf("CPU time spent in user mode: %ld\n", info->user_time);
        printf("CPU time spent in system mode: %ld\n", info->sys_time);
        printf("Total user time of children: %ld\n", info->cutime);
        printf("Total system time of children: %ld\n", info->cstime);
        printf("User ID of process owner: %ld\n", info->uid);
        printf("Name of program executed: %s\n", info->comm);

        free(info);
        return 0;
}

	