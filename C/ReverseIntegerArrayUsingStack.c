#include<stdio.h>
#include<stdlib.h>
#include<string.h>	

struct Node{
	int charr;
	struct Node* link;
};
struct Node* top;
int* reverse(int *c, int n);
void push(int data);
void pop();
struct Node* getTop();
void push(int data)
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
void print(){
	struct Node* temp = top;
	printf("%s\n", "print the stack	");
	while(temp != NULL)
	{
		printf("%d", temp->charr);
		temp = temp -> link;
	}
	printf("\n");
}

int* reverse(int *c, int n)
{int i;
	for(i = 0; i < n; i++)
	{
		printf("%d\n",c[i]);
		push(c[i]);
	}
	print();
	int j;
	printf("the top = %d\n", top->charr);
	for(j = 0; j < n; j++){	
		c[j] = top->charr;
		pop();
	}
	return c;
}

void main()
{
	top = NULL;
	int str[51];int *strRev;
	int k;
	for(k = 0; k < 5; k++){
		printf("%s\n", "Enter the string");
		scanf("%d", &str[k]);
	}
   	//gets(str); 
   	//printf("%s\n",str);
  	strRev = reverse(str, 5);
  	int i;
  	for(i = 0; i < 5; i++)
	{
		printf("%d\n",strRev[i]);
	}
   	//printf("Reverse string = \n", strRev);
}
  /*read string with spaces scanf("%[^\n]s",str);*/