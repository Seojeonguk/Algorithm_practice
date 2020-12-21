#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, ans, X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
bool visit[53][53];
char land[53][53];
queue<pair<int, int> > q;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		scanf(" %s", land[i]);


	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (land[i][j] == 'L' && !visit[i][j]) {
				ans++;
				q.push({ i,j });
				visit[i][j] = true;

				while (!q.empty()) {
					auto outdata = q.front();
					q.pop();

					for (int i = 0; i < 4; i++) {
						auto indata = outdata;
						indata.first += X[i];
						indata.second += Y[i];

						if (indata.first < 0 || indata.second < 0 || indata.first >= n || indata.second >= m || visit[indata.first][indata.second] || land[indata.first][indata.second] == 'W') continue;
						q.push(indata);
						visit[indata.first][indata.second] = true;
					}
				}
			}
		}
	}

	printf("%d\n", ans);
}