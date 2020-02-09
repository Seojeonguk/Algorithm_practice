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

	for (int i = 1; i <= n; i++) {
		priority_queue<int> q;
		for (int j = 0; j < 5; j++) {
			int x; scanf("%d", &x);
			q.push(x);
		}
		printf("Case #%d: %d\n", i, q.top());
	}
}