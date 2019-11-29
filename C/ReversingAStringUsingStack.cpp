//#include<iostream>
#include<stack>
	
#include<stdlib.h>
#include<string.h>	
#include<stdio.h>
using namespace std;
char* reverse(char *c, int n);

char* reverse(char *c, int n)
{
	//std::
	stack<char> s;

	for(int i = 0; i < n ; i++)
	{
		s.push(c[i]);
	}

	// Printing content of stack 
    // while (!s.empty()) { 
    //     printf("%c", s.top()); 
    //     s.pop(); 
    // } 
	for (int i = 0; i < n; ++i)
	{
		c[i] = s.top();
		s.pop();
	}
	return c;
}

int main()
{
	char str[51];char *revStr;
	printf("Enter the string\n");
	gets(str);
	printf("%s\n", str);
	revStr = reverse(str, strlen(str));
	printf("reversed string = %s\n", revStr);
	return 0;
}