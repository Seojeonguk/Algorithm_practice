#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, a, b;
vector<int> v[32001];
int d[32001];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &a, &b);
		d[b]++;
		v[a].push_back(b);
	}

	queue<int> q;
	for (int i = 1; i <= n; i++) if (!d[i]) q.push(i);
	while (!q.empty()) {
		int outdata = q.front();
		q.pop();
		printf("%d ", outdata);

		int size = v[outdata].size();

		for (int i = 0; i < size; i++) {
			if (!--d[v[outdata][i]])
				q.push(v[outdata][i]);
		}
	}
}