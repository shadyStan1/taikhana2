#include<stdio.h>
#include<stdlib.h>
struct Node
{
	int data;
	struct Node* next;
};
struct Node* head;

void insertAtN(int data, int n)
{
	struct Node* temp1 = (struct Node*)malloc(sizeof(struct Node));
	(*temp1).data = data;
	(*temp1).next = NULL;
	if (n == 1)
	{
		(*temp1).next = head;
		head  = temp1;
		return;
	}

	struct Node* temp2 = head;

	for(int i = 1; i < n-1 ; i++ )
	{
		temp2 = (*temp2).next;
	}

	(*temp1).next = (*temp2).next;
	(*temp2).next = temp1;
}

void print()
{
	struct Node* temp = head;
	printf("List is :");
	while(temp != NULL)
	{
		printf("%d ", temp->data);
		temp = (*temp).next;
	}
	printf("\n");
}
int main()
{
	head = NULL;
	insertAtN(3,1);
	print();
	insertAtN(2,2);
	print();
	insertAtN(6,3);
	print();
	insertAtN(7,2);
	print();
	return 0;
}