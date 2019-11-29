//LevelOrderTraversalOfBinaryTree.cpp
#include <iostream>
#include <queue>
#include<stdio.h>
#include<stdlib.h>
using namespace std;

struct BstNode{
	char value;
	struct BstNode* left;
	struct BstNode* right;
};

void insert(char data);
void levelOrderTraversal();
struct BstNode* GetNewNode(char data);

struct BstNode* root;

int main()
{
	cout<<"Into the main method"<<"\n";
	root = NULL;
	insert('M');
	insert('B');
	insert('Q');
	insert('Z');
	insert('A');
	insert('C');
	//insert(27);
	levelOrderTraversal();
}

void levelOrderTraversal()
{
	if(root == NULL) return;

	queue<BstNode*> queueElements;
	queueElements.push(root);

	while(!queueElements.empty())
	{

		struct BstNode* temp = queueElements.front();
		queueElements.pop();
		std::cout<<temp->value<<", ";
		if(temp->left != NULL) queueElements.push(temp->left);

		if(temp->right != NULL) queueElements.push(temp->right);

	}
}

void insert(char data)
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

struct BstNode* GetNewNode(char data)
{
	BstNode* newNode = new BstNode();
	newNode->value = data;
	newNode->left = NULL;
	newNode->right = NULL;
	return newNode;
}