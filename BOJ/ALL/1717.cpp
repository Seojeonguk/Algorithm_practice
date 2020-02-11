#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
ll chk[22], brr[22];
int n, k, b;
int par[1000002], note[1000002];

int find(int a) {
	if (a == par[a]) return a;
	return par[a] = find(par[a]);
}

void setting(int a, int b) {
	int u = find(a), v = find(b);
	if (note[u] > note[v]) swap(u, v);
	par[u] = v;
	if (note[u] == note[v]) note[v]++;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	for (int i = 0; i <= n; i++) par[i] = i;
	int a, b, c;
	for (int i = 0; i < k; i++) {
		scanf("%d %d %d", &a, &b, &c);

		if (!a) setting(b, c);
		else puts(find(b) == find(c) ? "YES" : "NO");
	}
}