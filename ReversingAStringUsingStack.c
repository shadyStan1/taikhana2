#include<stdio.h>
#include<stdlib.h>
#include<string.h>	

struct Node{
	char charr;
	struct Node* link;
};
struct Node* top;
char* reverse(char *c, int n);
void push(char data);
void pop();
struct Node* getTop();
void push(char data)
{
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	temp->charr = data;
	temp->link = top;
	top = temp;
}
void pop()
{
	struct Node* temp = top;
	top = top->link;
	free(temp);
}
struct Node* getTop()
{
	return top;
}
void print()
{
	struct Node* temp = top;
	printf("%s\n", "Into Stack print method");
	while(temp != NULL)
	{
		printf("%c", temp->charr);
		temp = temp -> link;
	}
	printf("\n");
}

char* reverse(char *c, int n)
{int i;
	for(i = 0; i < n; i++)
	{
		printf("%c\n",c[i]);
		push(c[i]);
	}
	print();
	printf("%c\n",top->charr);
	int j;
	for(j = 0; j < n; j++){
		c[j] = top->charr;
		pop();
	}
	return c;
}

void main()
{
	top = NULL;
	char str[51];char *strRev;	
	printf("%s\n", "Enter the string");
   	gets(str); 
   	printf("%s\n",str);
  	strRev = reverse(str, strlen(str));
 //  	int i;
 //  	for(i = 0; i < strlen(strRev); i++)
	// {
	// 	printf("%c\n",strRev[i]);
	// }
   	printf("Reverse string = %s\n", strRev);
}
  /*read string with spaces scanf("%[^\n]s",str);*/