//InfixToPostfix.cpp
#include <stdio.h>
#include <stack>
#include <iostream>
#include <string>
#include<stdlib.h>

using namespace std;

string ConvertInfixToPostfix(string exp);
bool isOperator(char oprtr);
bool isAlphabet(char alpha);
bool hasHigherPrecedence(char c, char stackTop);
int GetOperatorWeight(char c);

int main()
{
	//top = NULL;
	string str;//int *strRev;
	printf("Enter the string\n");
	//gets(str);
	getline(cin,str);
	//fgets(str, sizeof(str), stdin);
	cout<<str<<"\n";
	string postFixExp = ConvertInfixToPostfix(str);
	cout<<"Infix  to Postfix, exp becomes = "<<postFixExp<<"\n";
   //	printf("Evaluation Result = %d\n", evalResult);
   	return 0;
}

string ConvertInfixToPostfix(string exp)
{
	stack<char> s;
	string postFixExp;
	for (int i = 0; i < exp.length(); ++i)
	{
		if(exp[i] == ',' || exp[i] == ' ') continue;

		else if(isAlphabet(exp[i])) postFixExp = postFixExp + exp[i];

		else if(exp[i] == '(') s.push(exp[i]);

		else if(isOperator(exp[i]))
		{
			while(!s.empty() && s.top() != '(' && !hasHigherPrecedence(exp[i], s.top()))
			{
				postFixExp = postFixExp + s.top();
				s.pop(); 
			}
			s.push(exp[i]);
		}

		else if(exp[i] == ')')
		{
			while(!s.empty() && s.top() != '(')
			{	
				postFixExp = postFixExp + s.top();
				s.pop();
			}
			s.pop();
		}
	}
}

bool hasHigherPrecedence(char c, char stackTop)
{
	int oprtrWeight = GetOperatorWeight(c);
	int topWeight = GetOperatorWeight(stackTop);
	if(oprtrWeight >= topWeight)
		return true;
	return false;
}

int GetOperatorWeight(char c){
	int opWeight = -1;
	switch(c)
	{
		case '+':
		case '-':
				opWeight = 1;
		case '*':
		case '/':
				opWeight = 2;
		case '^': opWeight = 3;
	}
	return opWeight;
}

bool isOperator(char oprtr)
{
	if(oprtr == '*' || oprtr == '/' || oprtr == '+' || oprtr == '-')
		return true;

	return false;
}

bool isAlphabet(char alpha)
{
	if((alpha >= 97 && alpha <= 122) || (alpha >= 65 && alpha <= 91))
		 return true;
	return false;
}















/*
  Infix to postfix conversion in C++ 
  Input Postfix expression must be in a desired format. 
  Operands and operator, both must be single character.
  Only '+'  ,  '-'  , '*', '/' and '$' (for exponentiation)  operators are expected. 
#include<iostream>
#include<stack>
#include<string>

using namespace std;

// Function to convert Infix expression to postfix 
string InfixToPostfix(string expression);

// Function to verify whether an operator has higher precedence over other
int HasHigherPrecedence(char operator1, char operator2);

// Function to verify whether a character is operator symbol or not. 
bool IsOperator(char C);

// Function to verify whether a character is alphanumeric chanaracter (letter or numeric digit) or not. 
bool IsOperand(char C);

int main() 
{
	string expression; 
	cout<<"Enter Infix Expression \n";
	getline(cin,expression);
	string postfix = InfixToPostfix(expression);
	cout<<"Output = "<<postfix<<"\n";
}

// Function to evaluate Postfix expression and return output
string InfixToPostfix(string expression)
{
	// Declaring a Stack from Standard template library in C++. 
	stack<char> S;
	string postfix = ""; // Initialize postfix as empty string.
	for(int i = 0;i< expression.length();i++) {

		// Scanning each character from left. 
		// If character is a delimitter, move on. 
		if(expression[i] == ' ' || expression[i] == ',') continue; 

		// If character is operator, pop two elements from stack, perform operation and push the result back. 
		else if(IsOperator(expression[i])) 
		{
			while(!S.empty() && S.top() != '(' && HasHigherPrecedence(S.top(),expression[i]))
			{
				postfix+= S.top();
				S.pop();
			}
			S.push(expression[i]);
		}
		// Else if character is an operand
		else if(IsOperand(expression[i]))
		{
			postfix +=expression[i];
		}

		else if (expression[i] == '(') 
		{
			S.push(expression[i]);
		}

		else if(expression[i] == ')') 
		{
			while(!S.empty() && S.top() !=  '(') {
				postfix += S.top();
				S.pop();
			}
			S.pop();
		}
	}

	while(!S.empty()) {
		postfix += S.top();
		S.pop();
	}

	return postfix;
}

// Function to verify whether a character is english letter or numeric digit. 
// We are assuming in this solution that operand will be a single character
bool IsOperand(char C) 
{
	if(C >= '0' && C <= '9') return true;
	if(C >= 'a' && C <= 'z') return true;
	if(C >= 'A' && C <= 'Z') return true;
	return false;
}

// Function to verify whether a character is operator symbol or not. 
bool IsOperator(char C)
{
	if(C == '+' || C == '-' || C == '*' || C == '/' || C== '$')
		return true;

	return false;
}

// Function to verify whether an operator is right associative or not. 
int IsRightAssociative(char op)
{
	if(op == '$') return true;
	return false;
}

// Function to get weight of an operator. An operator with higher weight will have higher precedence. 
int GetOperatorWeight(char op)
{
	int weight = -1; 
	switch(op)
	{
	case '+':
	case '-':
		weight = 1;
	case '*':
	case '/':
		weight = 2;
	case '$':
		weight = 3;
	}
	return weight;
}

// Function to perform an operation and return output. 
int HasHigherPrecedence(char op1, char op2)
{
	int op1Weight = GetOperatorWeight(op1);
	int op2Weight = GetOperatorWeight(op2);

	// If operators have equal precedence, return true if they are left associative. 
	// return false, if right associative. 
	// if operator is left-associative, left one should be given priority. 
	if(op1Weight == op2Weight)
	{
		if(IsRightAssociative(op1)) return false;
		else return true;
	}
	return op1Weight > op2Weight ?  true: false;
}*/
