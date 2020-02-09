#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, k,x,y;
bool visit[101];
vector<int> v[101];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	for (int i = 0; i < k; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	queue < pair<int, int> > q;
	q.push({ 1,0 });
	visit[1] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second == 6) continue;
		int size = v[outdata.first].size();

		for (int i = 0; i < size; i++)
			if (!visit[v[outdata.first][i]]) {
				visit[v[outdata.first][i]] = true;
				q.push({ v[outdata.first][i],outdata.second + 1 });
			}
	}
	for(int i=1;i<=n;i++)
		if (!visit[i]) {
			puts("Big World!");
			return 0;
		}
	puts("Small World!");
}