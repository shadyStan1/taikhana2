#include<stdio.h>
#include<stdlib.h>
void main()
{
	int a = 10;
	int *ptr;
	ptr = &a;
	printf("%p\n", ptr);
	//printf(&ptr);
}	