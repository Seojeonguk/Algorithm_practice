#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, ans[10005];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	ans[1] = 1;
	while (1) {
		scanf("%d", &n);
		if (!n) break;
		if(!ans[n]) 
			for (int i = 2; i <= n; i++)
				ans[i] = ans[i - 1] + 2 * (i-1);
		printf("%d => %d\n", n,ans[n]);
	}
}