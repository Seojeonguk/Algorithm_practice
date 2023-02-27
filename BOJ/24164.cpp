#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int ans, n, m, a, b;
vector<int> v[10001];
bool isVisit[10001];

void solve(int st) {
	queue<int> q;
	isVisit[st] = true;
	q.push(st);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		for (int next : v[now]) {
			if (isVisit[next]) continue;
			isVisit[next] = true;
			q.push(next);
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	while (m--) {
		scanf("%d %d", &a, &b);
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for(int i=1;i<=n;i++)
		if (!isVisit[i]) {
			ans++;
			solve(i);
		}

	printf("%d\n", ans - 1);
}
