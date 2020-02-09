#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, k, x, u, d;
vector<int> v[300003];
bool visit[300003];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &n, &m, &k, &x);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &u, &d);
		v[u].push_back(d);
	}

	queue<pair<int, int> > q;
	visit[x] = true;
	q.push({ x,0 });

	priority_queue<int> pq;
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second == k) {
			pq.push(-outdata.first);
			continue;
		}

		int size = v[outdata.first].size();

		for (int i = 0; i < size; i++) {
			if (!visit[v[outdata.first][i]]) {
				visit[v[outdata.first][i]] = true;
				q.push({ v[outdata.first][i],outdata.second + 1 });
			}
		}
	}
	if (pq.empty()) puts("-1");
	else {
		while (!pq.empty()) {
			printf("%d\n", -pq.top());
			pq.pop();
		}
	}
}