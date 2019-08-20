#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;
int arr[10];
bool visit[10];

void solve(int cnt) {
	if (cnt == m) {
		for (int i = 0; i < m; i++) printf("%d ", arr[i]);
		puts("");
		return;
	}

	for (int i = 1; i <= n; i++) {
		if (!visit[i]) {
			visit[i] = true;
			arr[cnt] = i;
			solve(cnt + 1);
			visit[i] = false;
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	solve(0);
}