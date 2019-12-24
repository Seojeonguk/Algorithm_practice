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

	int a = n / 2;
	int b = n / 2 + (n % 2 == 0 ? 0 : 1);

	printf("%d\n", (a + 1)*(b + 1));
}