#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, m1, m2,lilypad[32][32],sx,sy;
bool visit[32][32];
int X[] = { 1,1,-1,-1,1,1,-1,-1 }, Y[] = { 1,-1,1,-1,1,-1,1,-1 };
struct d{
	int cnt,x, y;	
};

bool operator<(d a, d b) {
	return a.cnt > b.cnt;
}

priority_queue<d> pq;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &n, &m, &m1, &m2);

	for (int i = 0; i < 2; i++) {
		for (int j = i * 4; j < i * 4 + 4; j++) {
			X[j] *= m1;
			Y[j] *= m2;
		}
		swap(m1, m2);
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &lilypad[i][j]);
			if (lilypad[i][j] == 3) sx = i, sy = j;
		}
	}
	visit[sx][sy] = true;
	pq.push({ 0,sx,sy });
	while (!pq.empty()) {
		d outdata = pq.top();
		pq.pop();

		if (lilypad[outdata.x][outdata.y] == 4) {
			printf("%d\n", outdata.cnt);
			break;
		}

		for (int i = 0; i < 8; i++) {
			d indata = outdata;
			indata.x += X[i];
			indata.y += Y[i];

			if (indata.x < 0 || indata.y < 0 || indata.x >= n || indata.y >= m || visit[indata.x][indata.y] || lilypad[indata.x][indata.y] == 0 || lilypad[indata.x][indata.y] == 2) continue;
			pq.push({ outdata.cnt + 1,indata.x,indata.y });
			visit[indata.x][indata.y] = true;
		}
	}
}