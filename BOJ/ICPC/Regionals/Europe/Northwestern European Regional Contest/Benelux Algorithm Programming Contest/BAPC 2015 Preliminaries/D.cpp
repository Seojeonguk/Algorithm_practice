#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int X[] = { 1,0,-1,0,1,1,-1,-1 }, Y[] = { 0,1,0,-1,1,-1,1,-1 };
int t, n;
char ga[103][103];
bool visit[103][103];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {

		scanf("%d", &n);

		memset(visit, 0, sizeof visit);

		queue<pair<int, int> > q;
		for (int i = 0; i < n; i++) {
			scanf(" %s", ga[i]);
			for (int j = 0; j < n; j++)
				if (ga[i][j] == 'w')
					q.push({ i,j });
		}

		int cnt = 0;
		while (!q.empty()) {
			auto outdata = q.front();
			q.pop();

			for (int i = 0; i < 8; i++) {
				auto indata = outdata;
				indata.first += X[i];
				indata.second += Y[i];
				if (indata.first < 0 || indata.second < 0 || indata.first >= n || indata.second >= n || ga[indata.first][indata.second] != '-' || visit[indata.first][indata.second])
					continue;
				visit[indata.first][indata.second] = true;
				q.push(indata);
				cnt++;
			}
		}

		printf("%d\n", cnt);
	}
}