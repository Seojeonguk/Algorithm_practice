#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
#define pipii pair<int, pair<int,int> >
struct space {
	int z, x, y;
};

int n, ans;
char spaces[101][101][101];
bool isVisit[101][101][101];

int zxy[6][3] = {{1,0,0},{-1,0,0},{0,-1,0},{0,1,0},{0,0,-1},{0,0,1}};

bool isOut(int z, int x, int y) {
	return (z<0 || x<0 || y<0 || z>n - 1 || x>n - 1 || y>n - 1);
}

void solve(int z, int x, int y) {
	queue<space> q;
	q.push({ z,x,y });
	isVisit[z][x][y] = true;

	while (!q.empty()) {
		int x = q.front().x;
		int y = q.front().y;
		int z = q.front().z;
		q.pop();

		for (int dir = 0; dir < 6; dir++) {
			int nextX = x + zxy[dir][1];
			int nextY = y + zxy[dir][2];
			int nextZ = z + zxy[dir][0];

			if (isOut(nextZ, nextX, nextY) || isVisit[nextZ][nextX][nextY] || spaces[nextZ][nextX][nextY]!='*')
				continue;
			isVisit[nextZ][nextX][nextY] = true;
			q.push({ nextZ,nextX,nextY });
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++)
			scanf(" %s", spaces[k][i]);
	}

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (spaces[k][i][j] == '*' && !isVisit[k][i][j]) {
					ans++;
					solve(k, i, j);
				}
			}
		}
	}

	printf("%d\n", ans);
}
