#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m;
queue<int> q;
vector<pair<int,int> > v[1001];
int d[1001], path[1001], cnt[1001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		int u, a, c;
		scanf("%d %d %d", &u, &a, &c);
		cnt[a]++;
		v[u].push_back({ a,c });
	}

	if (n == 1) {
		printf("0\n1\n");
		return 0;
	}

	q.push(1);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		if (now == 1 && d[now]) {
			break;
		}

		int size = v[now].size();
		for (int i = 0; i < size; i++) {
			int nextIdx = v[now][i].first;
			int nextCost = v[now][i].second;

			if (d[nextIdx] < d[now] + nextCost) {
				d[nextIdx] = d[now] + nextCost;
				path[nextIdx] = now;
			}
			cnt[nextIdx]--;
			if (!cnt[nextIdx]) {
				q.push(nextIdx);
			}
		}
	}

	printf("%d\n", d[1]);

	stack<int> s;
	int idx = 1;

	while (1) {
		s.push(idx);
		idx = path[idx];
		if (idx == 1) {
			s.push(1);
			break;
		}
	}
	while (!s.empty()) {
		printf("%d ", s.top());
		s.pop();
	}
}