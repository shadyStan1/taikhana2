#include<stdio.h>
#include<stdlib.h>
struct Node
{
	int data;
	struct Node* link;
};
//struct Node* header;
struct Node* insert(struct Node* head, int data)
{
	struct Node* temp = (struct Node*)malloc(sizeof(struct Node));
	(*temp).data = data;
	(*temp).link = NULL;

	if(head == NULL) head = temp;

	else
	{
		struct Node* temp1 = head;
		while((*temp1).link != NULL)
			{	
				temp1 = (*temp1).link;
			}
			(*temp1).link = temp;
	}
	return head;
}

void print(struct Node* head)
{
	printf("List is :");
	while(head != NULL)
	{
		printf("%d ", (*head).data);
		head = (*head).link;
	}
	printf("\n");
}

struct Node* reverse(struct Node* head)
{
	struct Node *current, *next, *prev;
	prev = NULL;
	current = head;
	while(current != NULL)
	{
		next = (*current).link;
		(*current).link = prev;
		prev = current;
		current = next;
	}
	head = prev;return head;
}
void main()
{
	struct Node* head = NULL;
	head = insert(head, 2);
	head = insert(head, 5);
	head = insert(head, 7);
	print(head);
	head = reverse(head);
	print(head);
}
http://www.ubuntugeek.com/how-to-install-c-and-c-compilers-in-ubuntu-and-testing-your-first-c-and-c-program.html
https://askubuntu.com/questions/532842/how-do-i-install-aptitude-on-ubuntu
