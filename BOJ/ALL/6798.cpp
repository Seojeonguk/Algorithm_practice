#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int sx, sy, dx, dy,chk[9][9];
int X[] = { 1,2,2,1,-1,-2,-2,-1 }, Y[] = { 2,1,-1,-2,2,1,-1,-2 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(chk, -1, sizeof chk);
	scanf("%d %d %d %d", &sx, &sy, &dx, &dy);

	queue<pair<int, int> > q;
	q.push({ sx,sy });
	chk[sx][sy] = 0;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.first == dx && outdata.second == dy) {
			printf("%d\n", chk[outdata.first][outdata.second]);
			break;
		}

		for (int i = 0; i < 8; i++) {
			auto indata = outdata;
			indata.first += X[i];
			indata.second += Y[i];

			if (indata.first < 1 || indata.second < 1 || indata.first>8 || indata.second>8 || chk[indata.first][indata.second]!=-1) continue;
			q.push(indata);
			chk[indata.first][indata.second] = chk[outdata.first][outdata.second] + 1;
		}
	}
}