#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, x, y;
vector<int> v[200003];
bool visit[200004];

int solve() {
	queue<pair<int, int> > q;
	visit[1] = true;
	q.push({ 1,0 });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.first == n) return outdata.second;

		int size = v[outdata.first].size();
		for (int i = 0; i < size; i++) {
			if (!visit[v[outdata.first][i]]) {
				visit[v[outdata.first][i]] = true;
				q.push({ v[outdata.first][i],outdata.second + 1 });
			}
		}
	}
	
	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
	}

	printf("%d\n", solve());
}