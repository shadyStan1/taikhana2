#include<stdio.h>
#include<stdlib.h>
struct Node{
	int data;
	struct Node* next;
	struct Node* prev;
};
struct Node* getNewNode(int data);
struct Node* head;
void insertAtHead(int data)
{
	struct Node* newNode = getNewNode(data);
	if (head == NULL) {head = newNode;return;}

	
		(*newNode).next = head;
			(*head).prev = newNode;
		head = newNode;
	
}

void print()
{
	struct Node* temp = head;
	while(temp != NULL)
	{
		printf("%d ", (*temp).data);
		temp = (*temp).next;
	}
}

struct Node* getNewNode(int data)
{
	struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
	(*newNode).data = data;
	(*newNode).prev=NULL;
	(*newNode).next= NULL;
	return newNode;
}
void main()
{
	head = NULL;
	insertAtHead(2);
	insertAtHead(6);
	insertAtHead(9);
	print();
}


