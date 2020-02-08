#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int r, c, ans, X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
bool visit[102][102];
char bessie[102][102];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &r, &c);

	for (int i = 0; i < r; i++) scanf("%s", bessie[i]);

	for (int i = 0; i < r; i++)
		for (int j = 0; j < c; j++)
			if (bessie[i][j] == '#' && !visit[i][j]) {
				ans++;
				queue<pair<int, int> > q;
				q.push({ i,j });
				visit[i][j] = true;

				while (!q.empty()) {
					auto outdata = q.front();
					q.pop();

					for (int i = 0; i < 4; i++) {
						auto indata = outdata;
						indata.first += X[i],indata.second+=Y[i];
						if (indata.first < 0 || indata.second < 0 || indata.first >= r || indata.second >= c || visit[indata.first][indata.second] || bessie[indata.first][indata.second]=='.') continue;
						visit[indata.first][indata.second] = true;
						q.push(indata);
					}
				}
			}
	printf("%d\n", ans);
}