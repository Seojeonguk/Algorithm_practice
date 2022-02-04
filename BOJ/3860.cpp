#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int w, h, e, x1, y3, x2, y2, t, now_x, now_y, s, next_x, next_y, j, dist[32][32], X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
struct d { int x, y, nx, ny, t, m; };
d hole[32][32];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &w, &h);
		if (!w && !h) break;
		for (int i = 0; i < w; i++)
			for (int j = 0; j < h; j++)
				dist[i][j] = 1 << 28, hole[i][j].x = hole[i][j].y = hole[i][j].t = hole[i][j].nx = hole[i][j].ny = hole[i][j].m = 0;
		scanf("%d", &e);
		for (int i = 0; i < e; i++) {
			scanf("%d %d", &x1, &y3);
			hole[x1][y3].m = -1;
		}

		scanf("%d", &e);
		for (int i = 0; i < e; i++) {
			scanf("%d %d %d %d %d", &x1, &y3, &x2, &y2, &t);
			hole[x1][y3] = { x1,y3,x2,y2,t,1 };
		}

		vector<d> v;
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				dist[i][j] = 1 << 28;
				if (hole[i][j].m == -1) continue;
				if (!hole[i][j].m) {
					if (i == w - 1 && j == h - 1) continue;
					for (int k = 0; k < 4; k++) {
						next_x = i + X[k], next_y = j + Y[k];
						if (next_x < 0 || next_y < 0 || next_x >= w || next_y >= h || hole[next_x][next_y].m == -1) continue;
						v.push_back({ i,j,next_x,next_y,1,0 });
					}
				}
				else v.push_back(hole[i][j]);
			}
		}

		bool loop = false, chk = false;
		dist[0][0] = 0;
		for (int i = 1; i <= w * h; i++) {
			chk = false;
			for (auto next : v) {
				if (dist[next.x][next.y] == 1 << 28) continue;
				if (dist[next.nx][next.ny] > dist[next.x][next.y] + next.t) {
					dist[next.nx][next.ny] = dist[next.x][next.y] + next.t;
					chk = true;
				}
			}

			if (chk && i == w * h) loop = true;
		}

		loop ? puts("Never") : dist[w - 1][h - 1] == 1 << 28 ? puts("Impossible") : printf("%d\n", dist[w - 1][h - 1]);
	}
}