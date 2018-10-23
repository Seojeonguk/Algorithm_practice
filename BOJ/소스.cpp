#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	priority_queue<int> q;
	int n, a;
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%d", &a);
		q.push(a);
	}
	int res = 0;
	while (q.size() != 1) {
		int w = q.top();
		q.pop();
		int e = q.top();
		q.pop();
		res += w*e;
		q.push(w + e);
	}

	printf("%d\n", res);
}