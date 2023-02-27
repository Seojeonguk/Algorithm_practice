#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

#define pipii pair<int,pair<int,int> >
int n, m;
char carpets[502][502];
bool isVisit[502][502];
int dir[4][2] = { {-1,0},{1,0},{0,-1},{0,1} };

bool isOut(int x, int y) {
	return x<0 || y<0 || x>n - 1 || y>m - 1;
}

int solve() {
	queue<pipii> q;
	isVisit[0][0] = true;
	q.push({ 0,{0,0} });

	while (!q.empty()) {
		int cnt = q.front().first;
		int x = q.front().second.first;
		int y = q.front().second.second;
		q.pop();

		if (x == n - 1 && y == m - 1)
			return cnt;

		for (int i = 0; i < 4; i++) {
			int nextX = x + dir[i][0];
			int nextY = y + dir[i][1];

			if (isOut(nextX, nextY) || isVisit[nextX][nextY] || carpets[x][y] == carpets[nextX][nextY]) continue;
			isVisit[nextX][nextY] = true;
			q.push({ cnt + 1,{nextX,nextY} });
		}
	}

	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		scanf(" %s", carpets[i]);

	printf("%d\n", solve());
}
