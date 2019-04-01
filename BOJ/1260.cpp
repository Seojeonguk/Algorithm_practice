#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, st;
vector<int> v[1002];
vector<pair<int, int> > vv;
bool chk[1002];

void solve(int idx) {
	chk[st] = true;
	printf("%d ", idx);
	int size = v[idx].size();
	for (int i = 0; i < size; i++) {
		if (!chk[v[idx][i]]) {
			chk[v[idx][i]] = true;
			solve(v[idx][i]);
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &st);
	for (int i = 0; i < m; i++) {
		int n1, n2; scanf("%d %d", &n1, &n2);
		v[n1].push_back(n2);
		v[n2].push_back(n1);

	}

	for (int i = 1; i <= n; i++)
		sort(v[i].begin(), v[i].end());
	solve(st);

	memset(chk, false, sizeof chk);
	queue<int> q;
	q.push(st);
	chk[st] = true;
	puts("");
	while (!q.empty()) {
		int outdata = q.front();
		q.pop();
		printf("%d ", outdata);

		int size = v[outdata].size();
		for (int i = 0; i < size; i++) {
			if (!chk[v[outdata][i]]) {
				chk[v[outdata][i]] = true;
				q.push(v[outdata][i]);
			}
		}
	}
}