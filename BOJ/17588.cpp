#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,x,max_n;
bool chk[202];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		max_n = max(max_n, x);
		chk[x] = true;
	}

	bool check = true;
	for (int i = 1; i <= max_n; i++)
		if (!chk[i]) {
			printf("%d\n", i);
			check = false;
		}

	if (check) puts("good job");
}