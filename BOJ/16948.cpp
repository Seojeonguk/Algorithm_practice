#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char s[4], d[4];
bool visit[220][220];
int n,sx, sy, dx, dy, X[] = { -2,-2,0,0,2,2 }, Y[] = {-1,1,-2,2,-1,1};
int solve() {
	queue<pair<int, pair<int, int> > > q;
	q.push({ 0,{sx,sy} });
	visit[sx][sy] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second.first == dx && outdata.second.second == dy) return outdata.first;

		for (int i = 0; i < 6; i++) {
			int nx = outdata.second.first + X[i], ny = outdata.second.second + Y[i];
			if (nx < 0 || ny < 0 || nx >= n || ny >= n || visit[nx][ny]) continue;
			visit[nx][ny] = true;
			q.push({ outdata.first + 1,{nx,ny} });
		}
	}
	return -1;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d %d", &n, &sx, &sy, &dx, &dy);
	printf("%d\n", solve());
}