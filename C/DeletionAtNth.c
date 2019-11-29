#include<stdio.h>
#include<stdlib.h>
struct Node{
	int data;
	struct Node* next;
};
struct Node* head;
void insertAtN(int data, int n)
{
	struct Node* node = (struct Node*)malloc(sizeof(struct Node));
	(*node).data = data;
	(*node).next = NULL;
	if (n == 1)
	{
		(*node).next = head;
		head = node;
		return;
	}

	struct Node* temp1 = head;
	int i;
	for(i = 1; i < n-1; i++)
	{
		temp1 = (*temp1).next;
	}
	(*node).next = (*temp1).next;
	(*temp1).next = node;
}
void print()
{
	struct Node* temp = head;
	printf("List is :");
	while(temp != NULL)
	{
		printf("%d ", (*temp).data);
		temp = (*temp).next;
	}
	printf("\n");
}
void delete(int n)
{
	struct Node* temp1 = head;
	if(n == 1)
	{
		head = (*temp1).next;
		free(temp1);
	}
	int i;
	for (i = 1; i < n-1; ++i)
	{
		temp1 = (*temp1).next;
	}

	struct Node* temp2 = (*temp1).next;
	(*temp1).next = (*temp2).next;
	free(temp2);
}

void main()
{
	head = NULL;
	insertAtN(3,1);
	insertAtN(2,2);
	insertAtN(6,3);
	insertAtN(7,2);
	print();
	int n;
	printf("Which index u want to perform deletion at?\n");
	scanf("%d", &n);
	delete(n);
	print();
}