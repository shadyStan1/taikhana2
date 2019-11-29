//QueueImplUsingLinkedList.c
#include <stdlib.h>
#include <stdio.h>
struct Node {
	int data;
	struct Node* link;
};
struct Node* front = NULL;
struct Node* rear = NULL;
void enqueue(int element);
void dequeue();

void enqueue(int element)
{
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	temp->data = element;
	temp->link = NULL;

	if(front == NULL && rear == NULL)
	{
		front = temp; rear = temp;
		return;
	}
	else
	{
		rear->link = temp;
		rear = temp;
	}
}

void dequeue(){
	struct Node* temp = front;
	if(front == NULL && rear == NULL)
	{
		printf("%s\n","Queue is empty");
		return;
	}
	else if(front == rear)
	{
		front = rear = NULL;
	}
	else{
		front = front->link;
	}
	free(temp);
}

void printQueue()
{
	struct Node* temp = front;

	while(temp!= NULL){
		printf("%d ", temp->data);
		temp = temp->link;
	}
	printf("\n");
}
void main()
{
	enqueue(2);
	enqueue(3);
	enqueue(33);
	printQueue();
	dequeue();
	printQueue();
}