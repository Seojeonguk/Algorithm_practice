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

	printf("%d\n", n);
	printf("1 2 ");
	int cnt = 3;
	for (int i = 0; i < n - 3; i++)
		printf("%d ", cnt++);
	printf("997");
}