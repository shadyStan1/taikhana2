//CheckBinaryTreeIfBst.cpp
#include <iostream>
#include <math.h>
#include <queue>
#include <stdlib.h>
using namespace std;

struct BstNode{
	int value;
	struct BstNode* left;
	struct BstNode* right;
};

void insert(int data);
struct BstNode* GetNewNode(int data);
void inorderTraversal(struct BstNode* root);
void checkIfBst(queue<int> queueElements);

struct BstNode* root;

int main()
{
	cout<<"Into the main method"<<"\n";
	root = NULL;
	// insert('M');
	// insert('B');
	// insert('Q');
	// insert('Z');
	// insert('A');
	// insert('C');
	insert(15);insert(10);insert(20);
	insert(9);insert(11);insert(18);insert(27);
	inorderTraversal(root);
	//insert(27);
	//levelOrderTraversal();
}

void inorderTraversal(struct BstNode* root)
{
	queue<int> queueElements;
	if(root == NULL) return;

	inorderTraversal(root->left);
	//cout<<root->value<<", ";
	queueElements.push(root->value);
	inorderTraversal(root->right);

	checkIfBst(queueElements);
}

void checkIfBst(queue<int> queueElements)
{
	int check = 1;
	while(queueElements.front() != queueElements.back())
	{
		int temp = queueElements.front();
		queueElements.pop();
		
		if(!(temp < queueElements.front()))
		{
			cout<<"the tree is not bst";check = 0;
			break;
		}
	}

	if(check)
		cout<<"the tree is BST"<<"\n";
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