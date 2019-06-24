#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool chk[10002];
int n,x, y,ans;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);
		for (int j = x; j < y; j++)
			chk[j] = true;
	}

	for (int i = 0; i < 10000; i++)
		if (chk[i])
			ans++;

	printf("%d\n", ans);
}