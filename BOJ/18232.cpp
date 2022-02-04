#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m,s,d,x,y;
vector<int> v[300002];
bool visit[300002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &n, &m,&s,&d);
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}
	queue < pair<int, int> >q;
	visit[s] = true;
	q.push({ s,0 });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.first == d) {
			printf("%d\n", outdata.second);
			break;
		}

		int nx1 = outdata.first + 1,nx2=outdata.first-1;
		if (nx1 > 0 && nx1 <= n && !visit[nx1]) {
			visit[nx1] = true;
			q.push({ nx1,outdata.second+1 });
		}
		if (nx2 > 0 && nx2 <= n && !visit[nx2]) {
			visit[nx2] = true;
			q.push({ nx2,outdata.second + 1 });
		}
		int size = v[outdata.first].size();

		for (int i = 0; i < size; i++) {
			if (!visit[v[outdata.first][i]]) {
				visit[v[outdata.first][i]] = true;
				q.push({ v[outdata.first][i],outdata.second + 1 });
			}
		}
	}
}