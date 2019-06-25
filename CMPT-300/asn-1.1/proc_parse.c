#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{

  char buffer_1[1000];
  char buffer_2[1000];
  char buffer_3[1000];
  int i;

  FILE *fp;
  //Model Name
  fp=fopen("/proc/cpuinfo", "r");
  if ( fp ==NULL )
	{
		perror("Error while opening the file.\n");
		return 1;
	}
  
  for (i=0; i<5; i++) 
  {
    fgets(buffer_1, 1000, fp);
  }
  int counter = 0;
  for (i=13; i<=strlen(buffer_1); i++) 
  {
    buffer_2[counter] = buffer_1[i];
    counter++;
  }
  printf("CPU Model Name: ");
  printf("%s", buffer_2);
  

  //Kernel Version
  fp=fopen("/proc/version", "r");

  if( fp == NULL )
	{
		perror("Error while opening the file.\n");
		return 1;
	}

  if  ((fgets(buffer_1,1000,fp))!=NULL)
	{
	  printf("Kernel Version: ");
	  printf("%s", buffer_1);
	}

  fp=fopen("/proc/meminfo", "r");

  if( fp == NULL )
	{
		perror("Error while opening the file.\n");
		return 1;
	}
  fscanf(fp, "%s %s %s", buffer_1, buffer_2, buffer_3);
  printf( "Total Memory: %s %s\n", buffer_2, buffer_3);
  

  fp = fopen("/proc/uptime", "r");
	if( fp == NULL ) {
		printf("Error while opening the file.\n");
		return 1;
	}
	fscanf(fp, "%s %s", buffer_1, buffer_2);
	printf("Uptime: %s Seconds\n", buffer_1);
  fclose(fp);
  return 0;
}