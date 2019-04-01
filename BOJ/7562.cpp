#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, l, sx, sy, dx, dy, nx, ny;
bool visit[302][302];
struct d { int x, y, cnt; };
int X[] = { -1,-2,-2,-1,1,2,2,1 }, Y[] = { 2,1,-1,-2,-2,-1,1,2 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		memset(visit, 0, sizeof visit);
		scanf("%d %d %d %d %d", &l, &sx, &sy, &dx, &dy);
		queue<d> q;
		q.push({ sx,sy,0 });
		visit[sx][sy] = true;

		while (!q.empty()) {
			auto outdata = q.front();
			q.pop();

			if (outdata.x == dx && outdata.y == dy) {
				printf("%d\n", outdata.cnt);
				break;
			}

			for (int i = 0; i < 8; i++) {
				nx = outdata.x + X[i];
				ny = outdata.y + Y[i];
				if (nx < 0 || ny < 0 || nx > l - 1 || ny > l - 1 || visit[nx][ny]) continue;
				q.push({ nx,ny,outdata.cnt + 1 });
				visit[nx][ny] = true;
			}
		}
	}
}