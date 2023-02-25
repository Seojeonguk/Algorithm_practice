#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int p, c, ans;
int pastures[1001][2];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &p);

	for (int i = 0; i < p - 1; i++) {
		scanf("%d", &c);

		scanf("%d %d", &pastures[c][0], &pastures[c][1]);
	}

	queue<pair<int, int> > q;
	q.push({ 1,0 });

	while (!q.empty()) {
		int idx = q.front().first;
		int cnt = q.front().second;
		q.pop();

		if (idx == 0) {
			ans = max(ans, cnt);
			continue;
		}

		for (int dir = 0; dir < 2; dir++) {
			int next = pastures[idx][dir];
			q.push({ next,cnt + 1 });
		}
	}

	printf("%d\n", ans);
}
