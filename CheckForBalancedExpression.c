#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#define MAX_SIZE 100
char c[MAX_SIZE];
struct Node{
	char data;
	struct Node* next;
};
struct Node* top = NULL;
void push(char charac);
void pop();
void print();
void CheckForBalancedParenthesis(char exp[], int length)
{
	int i;
	for (i = 0; i < length; ++i)
	{
		if(exp[i] == '{' || exp[i] == '(' || exp[i] == '[')
		{
			push(exp[i]);
			//print();
		}
		else 
		{
			if (top == NULL)
			{
				printf("There is no matching closing parenthesis, so it's an unbalanced expression\n");
			}
			else if (exp[i] == '}')
			{
				if ((*top).data != '{')
					printf("There is no matching closing parenthesis, so it's an unbalanced expression\n");
				else pop();	
			}

			else if(exp[i] == ')')
			{
				if ((*top).data != '(')
					printf("There is no matching closing parenthesis, so it's an unbalanced expression\n");
					else pop();		
			}

			else if(exp[i] == ']')
			{
				if ((*top).data != '[')
					printf("There is no matching closing parenthesis, so it's an unbalanced expression\n");
				else pop();		
			}
				
		}
	}
		(top == NULL)? printf("expression is balanced\n"): printf("expression unbalanced\n");
}
void push(char charac)
{
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	(*temp).data = charac;
	(*temp).next = top;
	top = temp;
}

void pop()
{
	if(top == NULL)
	{
		printf("There are no items in the stack\n");
	}
	else
	{
		struct Node* temp = top;
		top = (*top).next;
		free(temp);
	}
}

void print()
{
	if(top == NULL)
	{
		printf("Stack is empty\n");return;
	}
	struct Node* temp = top;
	while(temp!= NULL)
	{
		printf("%d\n", ((*temp).data));
		temp = (*temp).next;
	}
	printf("\n");

}
void main()
{
	int length,i;
	printf("Enter a string of parenthesis\n");
	scanf("%s",c);
	length = strlen(c);
	CheckForBalancedParenthesis(c, length);
}