#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, x, y, z, dist[501];
vector<pair<int, int> > v[501];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) dist[i] = 1 << 29;
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &x, &y, &z);
		v[x].push_back({ z,y });
	}
	for (int i = 1; i <= n; i++) sort(v[i].begin(), v[i].end());
	queue<int> q;
	dist[1] = 0;
	q.push(1);
	bool loop = false, chk = false;
	int size = 0;
	for (int k = 1; k <= n; k++) {
		chk = false;
		size = q.size();
		for (int i = 0; i < size; i++) {
			auto outdata = q.front();
			q.pop();

			for (auto next : v[outdata]) {
				if (next.first + dist[outdata] < dist[next.second]) {
					chk = true;
					dist[next.second] = next.first + dist[outdata];
					q.push(next.second);
				}
			}
		}
		if (chk && k == n) loop = true;
	}

	if (loop) puts("-1");
	else {
		for (int i = 2; i <= n; i++)
			printf("%d\n", dist[i] == 1 << 29 ? -1 : dist[i]);
	}
}