//InorderSuccessorBst.cpp
#include <iostream>
#include <math.h>
#include <stdlib.h>
using namespace std;

struct BstNode
{
	int value;
	struct BstNode* left;
	struct BstNode* right;
};

void insert(int data);
struct BstNode* GetNewNode(int data);
struct BstNode* inoderSuccessor(struct BstNode* root, int data);
struct BstNode* SearchNode(struct BstNode* root, int data);

struct BstNode* root;

int main()
{
	cout<<"Into the main method"<<"\n";
	root = NULL;
	insert(15);insert(10);insert(20);
	insert(9);insert(11);insert(18);insert(27);
	struct BstNode* successor = inoderSuccessor(root, 27);
	cout<<"InorderSuccessor of 27 = "<<successor->value<<"\n";
}

struct BstNode* inoderSuccessor(struct BstNode* root, int data)
{

	struct BstNode* current = SearchNode(root, data);
	cout<<"Current Node = "<< current->value <<"\n";
	struct BstNode* successor = NULL;
	//Case 1: Node has a right subtree//find min in the right subtree
	if(current->right != NULL)
	{
		struct BstNode* temp = current;
		while(temp->left != NULL){
			temp = temp->left;
		}

		successor = temp;
		//return successor;
	}

	//Case 2 : Node doesn't have a right subtree
	//find the nearest ancestor
	else
	{
		struct BstNode* ancestor = root;

		while(ancestor != current)
		{	
			if(current->value < ancestor->value)
			{
				successor = ancestor;
				ancestor = ancestor->left;
			}

			else ancestor = ancestor->right;
		}	
	} 
	return successor;

}
	
struct BstNode* SearchNode(struct BstNode* root, int data)
{
	struct BstNode* temp = root;

	while(true)
	{
		if(temp == NULL) return NULL;

		else if(temp->value == data) return temp;

		else if(data <= temp->value) temp = temp -> left;

		else if(data > temp->value) temp = temp -> right;
	}
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

struct BstNode* GetNewNode(int data)
{
	BstNode* newNode = new BstNode();
	newNode->value = data;
	newNode->left = NULL;
	newNode->right = NULL;
	return newNode;
}