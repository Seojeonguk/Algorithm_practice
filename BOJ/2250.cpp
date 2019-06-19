#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

struct d {
	int l, r, parent;
};
int n, cnt = 1,max_high;
int arr[10002];
d p[10002];
vector<int> v[10002];
queue<pair<int, int> > q;

void solve(int idx, int high) {
	if (p[idx].l != -1) solve(p[idx].l, high + 1);
	max_high = max(high, max_high);
	v[high].push_back(idx);
	arr[idx] = cnt++;
	if (p[idx].r != -1) solve(p[idx].r, high + 1);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	memset(p, -1, sizeof p);

	int a,b,c;
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &a,&b,&c);
		p[a].l = b, p[a].r = c;
		p[b].parent = p[c].parent = a;
	}
	while (p[b].parent != -1) {
		b = p[b].parent;
	}
	solve(b, 1);
	int ans = 1,high_ans=1;
	for (int i = 1; i <= max_high; i++) {
		if (v[i].size() == 1) continue;
		if (ans < arr[v[i][v[i].size() - 1]] - arr[v[i][0]]+1) {
			ans = arr[v[i][v[i].size() - 1]] - arr[v[i][0]]+1;
			high_ans = i;
		}
	}

	printf("%d %d", high_ans, ans);
}