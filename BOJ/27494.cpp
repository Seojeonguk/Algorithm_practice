#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, ans, serial[4] = { 3,2,0,2 };

void solve(int x) {
	int idx = 0;
	while (x) {
		if (x % 10 == serial[idx]) idx++;
		if (idx == 4) break;
		x /= 10;
	}
	if (idx == 4)
		ans++;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 2023; i <= n; i++)
		solve(i);

	printf("%d\n", ans);
}
