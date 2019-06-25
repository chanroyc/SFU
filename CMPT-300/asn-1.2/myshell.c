#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <unistd.h>
#include <termios.h>

#define max 10
#define max_len  80

#define TRUE 1

void pipeit();
void jobs();

int main()
{
	int argc, size;
	char input[max_len], *argv[max], *sp, test, *cwd, *buffer;
	const char *delim = " \t\n";
	
	
	while(TRUE){
	printf("myshell@myshell:");
	cwd = getcwd(buffer, (size_t)size);
	fprintf(stdout, "~%s$ ", cwd);
	
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
			
			if(strcmp(argv[argc], "|") == 0)
				pipeit();
			if(strcmp(argv[argc], "&") == 0)
				jobs();
			sp = NULL;
		
		
		}

			if(strcmp(argv[0], "cd") == 0){
				if(argv[1] == NULL){
					chdir(getenv("HOME"));
				}else if(chdir(argv[1]) == -1){
					printf("cd '%s' : No such file or directory\n", argv[1]);
				}else{
					printf("Moving to: '%s'\n", argv[1]);
				}
	
				continue;
			}
			
			pid_t pid = fork();
			if(pid == -1){
				perror("Error ");
				exit(1);
			}else if(pid == 0){
				test = execvp(argv[0], argv);
				if(test == -1)
					perror("Error ");
					break;
			}else{
				int status;
				wait(&status);
			}
			}
	 }	

}

void pipeit()
{
	printf(" _______________________________________________________  \n");
	printf("| |                                                  | | \n");
	printf("| |        <---------  PIPING  --------->            | | \n");
	printf("| |                                                  | | \n");
	printf("| |                                                  | | \n");
        printf(" _______________________________________________________\n");
	printf("\n\n********************* Currently not working. *************************\n\n");
	printf("\n\n*************************** EXITING **********************************\n\n");
	exit(0);
	/*int pid[2];
	int fd[2];
	char *delim2 = " \t\n";
	
	if(pipe(fd)<0){
	perror("Pipe Failed: ");	
	exit(errno);
	}
	if((pid[0]=fork())<0){
	perror("Fork Failed: ");
	exit(errno);
	}
	if(!pid[0])
	{
	close(fd[0]);
	dup2(fd[1], 1);
	close(fd[1]);
	
	exit(0);
	}*/
	
	
}

void jobs()
{

	system("xdg-open http://www.wallpapersource.co/wp-content/uploads/2014/02/life-is-beautiful-steve-jobs-quote-hd-wallpaper.jpg");
	printf("\n\n********************* !!!!OMG STEVE JOBS!!!! *************************\n\n");
	printf("\n\n*************************** EXITING **********************************\n\n");

}


