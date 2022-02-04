#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
int arr[14];
int ans[7];

void dfs(int now,int cnt) {
	if (now > n) return;
	ans[cnt] = arr[now];
	if (cnt == 6) {
		for (int i = 1; i <= 6; i++)
			printf("%d ", ans[i]);
		puts("");
		return;
	}
	for (int i = now + 1; i < n; i++) dfs(i, cnt + 1);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &n);
		if (!n) break;
		
		for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

		for (int i = 0; i < n - 5; i++)
			dfs(i,1);
		puts("");
	}
}