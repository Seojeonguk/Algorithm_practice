#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int tc, n, x, q, y;
vector<int> v[21];
bool isVisit[21];

int solve(int st, int en) {
	memset(isVisit, false, sizeof isVisit);
	queue<pair<int, int> > q;
	q.push({ st,0 });
	isVisit[st] = true;

	while (!q.empty()) {
		int now = q.front().first;
		int cnt = q.front().second;
		q.pop();

		if (now == en)
			return cnt;

		for (int next : v[now]) {
			if (isVisit[next]) continue;
			isVisit[next] = true;
			q.push({ next,cnt + 1 });
		}
	}
	return 0;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d", &n) != EOF) {
		for (int i = 0; i < n; i++) {
			scanf("%d", &x);
			v[1].push_back(x);
			v[x].push_back(1);
		}
		for (int i = 2; i <= 19; i++) {
			scanf("%d", &n);

			for (int j = 0; j < n; j++) {
				scanf("%d", &x);
				v[i].push_back(x);
				v[x].push_back(i);
			}
		}

		printf("Test Set #%d\n", ++tc);
		scanf("%d", &q);
		for (int i = 0; i < q; i++) {
			scanf("%d %d", &x, &y);
			printf("%2d to %2d: %d\n", x, y, solve(x, y));
		}
		puts("");

		for (int i = 1; i <= 20; i++)
			v[i].clear();
	}
}
