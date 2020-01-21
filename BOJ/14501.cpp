#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, d[20];
pair<int, int> p[20];
int solve(int idx) {
	if (idx > n) return -9999999;
	else if (idx == n) return 0;
	int &ret = d[idx];
	if (ret != -1) return ret;
	ret = 0;
	
	return ret = max(solve(idx + 1), solve(idx + p[idx].first) + p[idx].second);
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(d, -1, sizeof d);
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d %d", &p[i].first, &p[i].second);

	printf("%d\n", solve(0));
}