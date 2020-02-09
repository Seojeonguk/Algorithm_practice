#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, arr[101][101], ans, k;
int X[] = { 0,1,0,-1 }, Y[] = { 1,0,-1,0 };
int ax, ay, bx, by;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d%d%d", &n, &m, &k);

	while (k--) {
		scanf("%d %d %d %d", &ax, &ay, &bx, &by);
		for (int i = ay; i < by; i++)
			for (int j = ax; j < bx; j++)
				arr[i][j] = true;
	}

	queue<pair<int, int> > q;
	vector<int> v;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!arr[i][j]) {
				q.push({ i,j });
				arr[i][j] = 1, ans = 0;
				while (!q.empty()) {
					auto outdata = q.front();
					q.pop();
					ans++;

					for (int i = 0; i < 4; i++) {
						int nx = outdata.first + X[i], ny = outdata.second + Y[i];
						if (nx < 0 || ny < 0 || nx > n - 1 || ny>m - 1 || arr[nx][ny])continue;
						q.push({ nx,ny });
						arr[nx][ny] = 1;
					}
				}
				v.push_back(ans);
			}
		}
	}

	sort(v.begin(), v.end());
	printf("%d\n", v.size());
	for (int i = 0; i < (int)v.size(); i++)
		printf("%d ", v[i]);
}