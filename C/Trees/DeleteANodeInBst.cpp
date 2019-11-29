//DeleteANodeInBst.cpp
#include <iostream>
#include <math.h>
#include <queue>
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
struct BstNode* DeleteNode(struct BstNode* root, int data);
int FindMin(struct BstNode* root);
void inorderTraversal(struct BstNode* root);

struct BstNode* root;

int main()
{
	cout<<"Into the main method"<<"\n";
	root = NULL;

	insert(15);insert(10);insert(20);
	insert(9);insert(11);insert(18);insert(27);
	//insert(12);insert(5);insert(15);
	//insert(3);insert(7);insert(13);insert(1);insert(9);insert(17);
	root = DeleteNode(root, 20);
	inorderTraversal(root);

	//insert(27);
}

void inorderTraversal(struct BstNode* root)
{
	if(root == NULL) return;

	inorderTraversal(root->left);
	cout<<root->value<<", ";
	//queueElements.push(root->value);
	inorderTraversal(root->right);
}

struct BstNode* DeleteNode(struct BstNode* root, int data)
{	
	if(root == NULL)
		return root;

	else if(data < root->value) root->left = DeleteNode(root->left, data);

	else if(data > root->value) root->right = DeleteNode(root->right, data);

	else
	{
		if(root->left == NULL && root->right == NULL)
		{
			delete root;
			root = NULL;
		}

		else if( root -> left == NULL)
		{
			struct BstNode* temp = root->right;
			root->value = temp->value;
			delete temp;
		}

		else if(root -> right == NULL)
		{
			struct BstNode* temp = root ->left;
			root->value = temp->value;
			delete temp;
		}

		else 
		{
			int temp = FindMin(root->right);
			root->value = temp;
			root->right = DeleteNode(root->right, temp);
		}
	}
	return root;
}

int FindMin(struct BstNode* root)
{
	struct BstNode* temp = root;

	while(temp->left != NULL)
	{
		temp = temp->left;
	}

	return temp->value;
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