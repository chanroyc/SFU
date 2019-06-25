#include <linux/kernel.h>
#include <linux/prinfo.h>
#include <linux/types.h>
#include <asm/current.h>
#include <linux/sched.h>

asmlinkage int sys_prinfo(struct prinfo *info)
{
	//Find the task_struct based on pid
	struct task_struct* desiredProcess;
	struct task_struct* younger_sibling;
	struct task_struct* older_sibling;
	struct list_head* traverse;
	struct task_struct* thisTaskStruct;
	struct list_head* traverse2;
	struct task_struct* thisTaskStruct2;
	struct list_head* tempTrav;
	struct task_struct* tempTaskStruct;
	struct task_struct* tempTaskStructPrev;
	long nanoseconds;
	long usertime;
	long systemtime;

	// error checking if prinfo is null
	if( info == NULL ) {
		return EINVAL;
	}

	desiredProcess = find_task_by_pid(info->pid);

	// Place values into prinfo
	info->state = (long)desiredProcess->state;
	
	// process' nice value
	info->nice = (long)desiredProcess->static_prio-120;

	// info pid given

	// find parent pid
	info->parent_pid = desiredProcess->parent->pid;

	// Find youngest child pid
	if( &desiredProcess->children == NULL ) {
		info->youngest_child_pid = 0;
	}
	/*
	else {
		list_for_each(tempTrav, &desiredProcess->children) {
			tempTaskStruct = list_entry(tempTrav, struct task_struct, sibling);
			printk("the pid: %d\n", tempTaskStruct->pid);
		}
	}
*/
	else {
		tempTaskStructPrev = list_entry(&desiredProcess->children, struct task_struct, sibling);
		list_for_each(tempTrav, &desiredProcess->children) {
			tempTaskStruct = list_entry(tempTrav, struct task_struct, sibling);
			if( tempTaskStruct->pid > tempTaskStructPrev->pid ) {
				tempTaskStructPrev = tempTaskStruct;
			}
		}
		//youngest_child = list_entry(desiredProcess->children.prev, struct task_struct, children);
		info->youngest_child_pid = tempTaskStructPrev->pid;
	}
	

	// Find pid oldest among younger siblings
	if( &desiredProcess->sibling == NULL ) {
		info->younger_sibling_pid = 0;
	}
	else {
		younger_sibling = list_entry(desiredProcess->sibling.prev, struct task_struct, sibling);
		info->younger_sibling_pid = younger_sibling->pid;
	}

	// Find pid of youngest among older siblings
	if( &desiredProcess->sibling == NULL ) {
		info->younger_sibling_pid = 0;
	}
	else {
		older_sibling = list_entry(desiredProcess->sibling.next, struct task_struct, sibling);
		info->older_sibling_pid = older_sibling->pid;
	}

	// Find process start time
	nanoseconds = ((long)desiredProcess->start_time.tv_sec) * 1000000000;
	nanoseconds += desiredProcess->start_time.tv_nsec;
	info->start_time = (unsigned long)nanoseconds;

	// CPU time spent in user mode
	usertime = (long)desiredProcess->utime;
	info->user_time = usertime;

	// CPU time spent in system mode
	systemtime = (long)desiredProcess->stime;
	info->sys_time = systemtime;

	// total user time of children
	if( &desiredProcess->children == NULL ) {
		info->cutime = 0;
	}
	else {
		long totalChilduTime = 0;
		list_for_each(traverse, &desiredProcess->children) {
			thisTaskStruct = list_entry(traverse, struct task_struct, sibling);
			totalChilduTime += (long)thisTaskStruct->utime;
		}
		info->cutime = totalChilduTime;
	}

	// total system time of children
	if( &desiredProcess->children == NULL ) {
		info->cstime = 0;
	}
	else {
		long totalChildstime = 0;
		list_for_each(traverse2, &desiredProcess->children) {
			thisTaskStruct2 = list_entry(traverse2, struct task_struct, sibling);
			totalChildstime += (long)thisTaskStruct2->stime;
		}
		info->cstime = totalChildstime;
	}

	// user id of process
	info->uid = (long)desiredProcess->uid;

	// Find name of program executed
	strncpy(info->comm, desiredProcess->comm, 16);

	return 0;
}
