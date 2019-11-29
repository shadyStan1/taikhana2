//BinarySearchTreeImpl.cpp
#include <iostream>
#include<stdio.h>
#include<stdlib.h>
#include<string.h>	

using namespace std;

void insert(int data);
bool search(int data);
struct BstNode* GetNewNode(int data);

struct BstNode
{
	int value;
	BstNode* left;
	BstNode* right;
};
struct BstNode* root;

int main()
{
	printf("Into the main method");
	root = NULL;
	insert(15);
	insert(10);
	insert(20);
	insert(9);
	insert(11);
	insert(18);
	insert(27);
	bool findEight = search(8);
	bool findTen = search(10);
	printf("found eight = %s\n", findEight ? "true" : "false");
	printf("found ten = %s\n", findTen ? "true" : "false");
	// printf("found ten %s\n", );
	// std::cout<<"Found ten "<<findTen;
	// std::cout<<"Found eight "<<findTen;
	return 1;
}

void insert(int data)
{
	if(root == NULL)
	{
		root = GetNewNode(data);
		return;
	}

	struct BstNode* temp = root;
	while(true)
	{	
		if(data <= temp->value)
		{
			if(temp->left == NULL)
			{	
				temp->left = GetNewNode(data);
				return;	
			}
			else
			{
				temp = temp->left;
			}
		}
		else if (data >= temp->value)
		{
			if(temp->right == NULL)
			{	
				temp->right = GetNewNode(data);
				return;	
			}
			else
			{
				temp = temp->right;
			}
		}
	}
	free(temp);
}
bool search(int data)
{
	struct BstNode* temp = root;
	while(true)
	{
		if(temp == NULL) return false;

		else if(temp->value == data) return true;

		else if(data <= temp->value) temp = temp -> left;	

		else if(data >= temp->value) temp = temp -> right;
	}
}

struct BstNode* GetNewNode(int data)
{
	BstNode* newNode = new BstNode();
	newNode->value = data;
	newNode->left = NULL;
	newNode->right = NULL;
	return newNode;
}
