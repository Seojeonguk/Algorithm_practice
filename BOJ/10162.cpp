#include<iostream>
using namespace std;
int main()
{
	int T;

	cin >> T;

	if(T%10!=0)
		cout << -1;

	else 
		cout << T/300 <<" "<< T%300/60 <<" "<< T%60/10;
}