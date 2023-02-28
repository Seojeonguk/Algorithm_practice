#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
bool isVisit[1000056];

int rev(int x) {
	int ret = 0;

	while (x) {
		ret = ret * 10 + x % 10;
		x /= 10;
	}

	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);

		memset(isVisit, false, sizeof isVisit);

		queue<pair<int, int> > q;
		q.push({ 1,1 });
		isVisit[1] = true;

		while (!q.empty()) {
			int cur = q.front().first;
			int cnt = q.front().second;
			q.pop();

			if (cur == n) {
				printf("Case #%d: %d\n", tc, cnt);
			}

			int next = cur + 1;
			if (next <= n && !isVisit[next]) {
				isVisit[next] = true;
				q.push({ next,cnt + 1 });
			}
			next = rev(cur);
			if (next <= n && !isVisit[next]) {
				isVisit[next] = true;
				q.push({ next,cnt + 1 });
			}
		}
	}
}
