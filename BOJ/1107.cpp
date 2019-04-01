#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, ans;
bool chk[10];

void solve() {
	queue<pair<int, int> > q;
	for (int i = 0; i < 10; i++) {
		if (!chk[i]) {
			q.push({ 1 , i });
		}
	}
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		ans = min(ans, outdata.first + abs(outdata.second - n));

		for (int i = 0; i < 10; i++) {
			if (!chk[i] && outdata.second && outdata.second * 10 + i < n * 2) {
				q.push({ outdata.first + 1 , outdata.second * 10 + i });
			}
		}

	}
}

int main() {
#ifdef _CONSOLE
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		int x; scanf("%d", &x);
		chk[x] = true;
	}
	ans = abs(100 - n);
	solve();
	printf("%d\n", ans);
}