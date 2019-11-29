//FactorialUsingRecursion.cpp
#include <iostream>
using namespace std;

int Factorial(int n);

int main()
{
	int n;
	std::cout<<"Enter the number to see its Factorial";
	std::cin>>n;

	int result = Factorial(n);
	return 1;
}

int Factorial(int n)
{
	int fact;
	std::cout<<"I am calculating the factorial F("<<n<<")\n";
	if(n == 0) return 1;

	fact = n * Factorial(n-1);
	
	std::cout<<"Done calculation of F("<<n<<") = "<<fact<<"\n";
	return fact;

}