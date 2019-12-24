#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	if (n % 8 == 6 || n % 8 == 4) puts("4");
	else if (n % 8 == 3 || n % 8 == 7) puts("3");
	else if (n % 8 == 2 || n % 8 == 0) puts("2");
	else if (n % 8 == 1) puts("1");
	else if (n % 8 == 5) puts("5");
}