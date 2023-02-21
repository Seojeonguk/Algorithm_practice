#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

#define pipii pair<int,pair<int,int> >

int n, m, ans, a, b, c, d;
bool isLove[10001];
priority_queue<pipii> pq;
int p[10001];
int find(int x) {
	if (x==p[x]) return p[x];
	return p[x] = find(p[x]);
}

void merge(int x, int y) {
	x = find(x);
	y = find(y);

	if (x == y) return;
	p[y] = x;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 1; i <= n; i++)
		p[i] = i;

	for (int i = 0; i < m; i++) {
		scanf("%d %d %d %d", &a, &b, &c, &d);
		
		if (d == 1) {
			isLove[a] = isLove[b] = true;
			merge(a, b);
		}
		else {
			pq.push({ c,{a,b} });
		}
	}

	while (!pq.empty()) {
		int cost = pq.top().first;
		int l = pq.top().second.first;
		int r = pq.top().second.second;
		pq.pop();

		l = find(l);
		r = find(r);

		if (l != r) merge(l, r);
		else ans += cost;
	}
	printf("%d\n", ans);
}
