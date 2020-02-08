#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
bool visit[10002];
vector<int> v[10002];
int n,x,y;
int solve() {
	queue<pair<int, int> > q;
	visit[1] = true;
	q.push({ 1,1 });
	int ret = 999999999;
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (!v[outdata.first].size()) {
			ret = min(ret, outdata.second);
			continue;
		}

		int size = v[outdata.first].size();
		for (int i = 0; i < size; i++) {
			if (visit[v[outdata.first][i]]) continue;
			visit[v[outdata.first][i]] = true;
			q.push({ v[outdata.first][i],outdata.second + 1 });
		}
	}
	return ret;
}
bool chk() {
	for (int i = 1; i <= n; i++)
		if (!visit[i]) return false;
	return true;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <= n; i++) {
		scanf("%d", &x);
		for (int j = 0; j < x; j++) {
			scanf("%d", &y);
			v[i].push_back(y);
		}
	}

	int tmp = solve();
	puts(chk() ? "Y" : "N");
	printf("%d\n", tmp);
}