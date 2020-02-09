#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int i, x;
bool visit[1000003];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int n;
	scanf("%d", &n);

	for (int a = 0; a < n; a++) {
		scanf("%d", &x);
		if (x <= 1000000) visit[x] = true;
	}

	for (i = 1; i <= 1000000; i++) {
		if (!visit[i]) break;
	}

	printf("%d\n", i);
}