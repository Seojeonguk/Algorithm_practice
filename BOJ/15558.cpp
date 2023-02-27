#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k;
int maps[200002][2];
bool isVisit[200002][2];
int dir[2] = { 1,-1 };

struct state {
	int idx, cnt;
	bool isRight;
};

int solve() {
	queue<state> q;
	isVisit[0][0] = true;
	q.push({ 0,0,false });

	while (!q.empty()) {
		state now = q.front();
		q.pop();

		if (now.idx >= n)
			return 1;

		for (int i = 0; i < 2; i++) {
			int next_idx = now.idx + dir[i];
			if (isVisit[next_idx][now.isRight] || !maps[next_idx][now.isRight] || next_idx < now.cnt+1) continue;
			isVisit[next_idx][now.isRight] = true;
			q.push({ next_idx,now.cnt + 1,now.isRight });
		}

		int next_idx = now.idx + k;
		if (isVisit[next_idx][!now.isRight] || !maps[next_idx][!now.isRight] || next_idx < now.cnt + 1) continue;
		isVisit[next_idx][!now.isRight];
		q.push({ next_idx,now.cnt + 1,!now.isRight });
	}
	return 0;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	memset(maps, 1, sizeof maps);

	for (int i = 0; i < 2; i++)
		for (int j = 0; j < n; j++)
			scanf("%1d", &maps[j][i]);

	printf("%d\n", solve());
}
