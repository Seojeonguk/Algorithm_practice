#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

const long long int MOD = 1e9+7;
int n, m,x,y;
int parent[5000];
long long int att[5002];
bool chk;
int find(int x) {
	if (x == parent[x]) return x;
	return find(parent[x]);
}

void merge(int u, int v) {
	chk = false;
	u = find(u);
	v = find(v);
	if (u == v) return;
	parent[u] = v;
	chk = true;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	att[1] = 1;
	for (int i = 2; i <= n; i++)
		att[i] = (att[i - 1] * 2 + att[i - 2]) % MOD;

	for (int i = 0; i <= n; i++)
		printf("%lld\n", att[i]);

	for (int i = 1; i <= n; i++) parent[i] = i;

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);

		merge(x, y);

		if (chk) n--;
		//printf("%lld\n", att[n]);

	}
}