#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, a, b, c, ans;
int par[1001], note[1001];
vector<pair<int, int> > v[1001];
int find(int x) { return par[x] = (par[x] == x) ? par[x] : find(par[x]); }
void setting(int u, int v) {
	int x = find(u), y = find(v);
	if (note[x] > note[y]) swap(x, y);
	par[x] = y;
	if (note[x] == note[y]) note[y]++;

}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i <= n; i++)par[i] = i;

	priority_queue<pair<int, pair<int, int> > > pq;
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &a, &b, &c);
		pq.push({ -c,{a,b} });
	}

	while (!pq.empty()) {
		auto outdata = pq.top();
		pq.pop();

		if (find(outdata.second.first) != find(outdata.second.second)) {
			setting(outdata.second.first, outdata.second.second);
			ans += -outdata.first;
		}
	}
	printf("%d\n", ans);
}