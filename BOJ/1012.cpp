#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, k, ans;
queue<pair<int, int> > q;
int X[] = { 0,1,0,-1 }, Y[] = { 1,0,-1,0 };
int arr[52][52];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int t; scanf("%d", &t);
	while (t--) {
		ans = 0;
		scanf("%d %d %d", &n, &m, &k);
		for (int i = 0; i < k; i++) {
			int x, y; scanf("%d %d", &x, &y);
			arr[x][y] = true;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j]) {
					ans++;
					q.push({ i,j });
					arr[i][j] = 0;

					while (!q.empty()) {
						auto outdata = q.front();
						q.pop();

						for (int i = 0; i < 4; i++) {
							int nx = outdata.first + X[i], ny = outdata.second + Y[i];
							if (nx < 0 || ny< 0 || nx >n - 1 || ny>m - 1 || !arr[nx][ny]) continue;
							arr[nx][ny] = 0;
							q.push({ nx,ny });
						}
					}
				}
			}
		}

		printf("%d\n", ans);
	}
}