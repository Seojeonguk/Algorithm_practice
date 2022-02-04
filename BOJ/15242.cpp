#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char s[4], d[4];
bool visit[10][10];
int sx, sy, dx, dy, X[] = { -1,1,-2,-2,2,2,1,-1 }, Y[] = {-2,-2,1,-1,1,-1,2,2};

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf(" %s %s", s, d);
	sx = s[0] - 'a';
	sy = s[1] - '1';
	dx = d[0] - 'a';
	dy = d[1] - '1';
	queue<pair<int, pair<int, int> > > q;
	q.push({ 0,{sx,sy} });
	visit[sx][sy] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		
		if (outdata.second.first== dx && outdata.second.second == dy) {
			printf("%d\n", outdata.first);
			break;
		}

		for (int i = 0; i < 8; i++) {
			int nx = outdata.second.first + X[i], ny = outdata.second.second + Y[i];
			if (nx<0 || ny<0 || nx>=8 || ny>=8 || visit[nx][ny]) continue;
			visit[nx][ny] = true;
			q.push({ outdata.first + 1,{nx,ny} });
		}
	}
}