#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool visit[102];
int n,m,u,v,up[102], down[102];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n + m; i++) {
		scanf("%d %d", &u, &v);
		if (i < n) up[u] = v;
		else down[u] = v;
	}
	queue<pair<int, int> > q;
	visit[1] = true;
	q.push({ 1,0 });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		if (outdata.first == 100) {
			printf("%d\n", outdata.second);
			break;
		}

		for (int i = 1; i <= 6; i++) {
			int next = outdata.first + i;
			if (next < 0 || next > 100) continue;
			if (up[next]) next = up[next];
			if (down[next]) next = down[next];
			if (visit[next]) continue;
			visit[next] = true;
			q.push({ next,outdata.second+1 });
		}
	}
}