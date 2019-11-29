//EvaluatePostExpression.cpp
#include<stack>
#include<iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>	
using namespace std;

int EvaluatePostExpression(char *exp);
bool isOperator(char oprtr);
bool isNumber(char num);
int performOp(int operand1, int operand2, char oprtr);

int main()
{
	//top = NULL;
	char str[51];//int *strRev;
	printf("Enter the string\n");
	gets(str);
	printf("%s\n", str);
	int evalResult = EvaluatePostExpression(str);
	
   	printf("Evaluation Result = %d\n", evalResult);
   	return 0;
}

int EvaluatePostExpression(char *exp)
{
	stack<int> s;
	for(int i = 0; i < strlen(exp); i++)
	{
		if(exp[i] == ',' || exp[i] == ' ') continue;
		
		else if(isOperator(exp[i]))
		{
			int operandOne = s.top();s.pop();
			int operandTwo = s.top();s.pop();
			int result = performOp(operandOne, operandTwo, exp[i]);
			s.push(result);
		}
		else if(isNumber(exp[i]))
		{
			int makeOperand = 0;
			while( i < strlen(exp) && isNumber(exp[i]))
			{
				makeOperand = (makeOperand*10) +  (exp[i] - '0');
				i++;
			}
			s.push(makeOperand);
			i--;
		}	
	}
	return s.top();
}

bool isOperator(char oprtr)
{
	if(oprtr == '*' || oprtr == '/' || oprtr == '+' || oprtr == '-')
		return true;

	return false;
}

bool isNumber(char num)
{
	if(num >= '0' && num <= '9') return true;
	return false;
}

int performOp(int operand1, int operand2, char oprtr)
{
	int sum;
	if(oprtr == '+') sum = operand1 + operand2;
	else if(oprtr == '-') sum = operand1 - operand2;
	else if(oprtr == '*') sum = operand1 * operand2;
	else if(oprtr == '/') sum = operand1 / operand2;
	else sum = -1;
	return sum;
}
// void print(){
// 	struct Node* temp = top;
// 	printf("%s\n", "print the stack	");
// 	while(temp != NULL)
// 	{
// 		printf("%d", temp->charr);
// 		temp = temp -> link;
// 	}
// 	printf("\n");
// }


  /*read string with spaces scanf("%[^\n]s",str);*/