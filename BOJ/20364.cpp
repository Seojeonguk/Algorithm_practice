#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int parent[1500000];
bool land[1500000];
int n, q,now,ori;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &q);

	for (int i = 2; i <= n; i++) parent[i] = i / 2;

	for (int i = 0; i < q; i++) {
		scanf("%d ", &ori);
		int now = ori;
		int ans = 0;
		while (now) {
			if (land[now]) ans = now;
			now = parent[now];
		}
		if (!ans) land[ori] = true;
		printf("%d\n", ans);
	}
}