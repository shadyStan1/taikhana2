#include<stdio.h>
#include<stdlib.h>
struct Node{
	int data;
	struct Node* next;
};
struct Node* head;
void insertAtBeginning(int x)
{
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	(*temp).data = x;
	(*temp).next = head;
	head = 	temp;

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
void main()
{
	head = NULL;
	int n, x, i;
	printf("How many numbers in list?\n");
	scanf("%d",&n);
	for( i = 0; i < n ;  i++)
	{
		printf("Enter the number\n");
		scanf("%d", &x);
		insertAtBeginning(x);
		print();
	}
}