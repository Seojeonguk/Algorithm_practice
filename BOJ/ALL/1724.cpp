#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool arr[1500][1500];
int n, m, c, sx, sy, dx, dy;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
vector<int> v;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m,&c);
	for (int i = 0; i < 2 * m + 1; i++)
		arr[0][i] = arr[2 * n][i] = true;
	for (int i = 0; i < 2 * n + 1; i++)
		arr[i][0] = arr[i][2 * m] = true;

	for (int i = 0; i < c; i++) {
		scanf("%d %d %d %d", &sx, &sy, &dx, &dy);
		sx *= 2;
		sy *= 2;
		dx *= 2;
		dy *= 2;
		if (sx == dx) {
			if (sy > dy) swap(sy, dy);
			for (int k = sy; k < dy; k++)
				arr[sx][k] = true;
		}
		else {
			if (sx > dx) swap(sx, dx);
			for (int k = sx; k < dx; k++)
				arr[k][sy] = true;
		}
	}

	for (int i = 0; i < 2 * n + 1; i++) {
		for (int j = 0; j < 2 * m + 1; j++)
			printf("%d", arr[i][j]);
		puts("");
	}
	for (int i = 0; i < 2 * n+1; i++) {
		if (!(i & 1)) continue;
		
		for (int j = 0; j < 2 * m+1; j++) {
			int cnt = 0;
			if (!(j & 1)) continue;
			if (arr[i][j]) continue;
			queue<pair<int, int> > q;
			q.push({ i,j });
			arr[i][j] = true;
			while (!q.empty()) {
				auto outdata = q.front();
				q.pop();
				if ((outdata.first & 1) && (outdata.second & 1))
					cnt++;

				for (int i = 0; i < 4; i++) {
					int x = outdata.first + X[i];
					int y = outdata.second + Y[i];
					if (arr[x][y]) continue;
					arr[x][y] = true;
					q.push({ x,y });
				}
			}
			v.push_back(cnt);
		}
	}

	sort(v.begin(), v.end());
	printf("%d\n%d", v[v.size() - 1], v[0]);
}