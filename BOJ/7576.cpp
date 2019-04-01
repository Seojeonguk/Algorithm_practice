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
int arr[1003][1003];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &m, &n);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 1) q.push({ i,j });
		}
	}
	while (!q.empty()) {
		int size = q.size();

		for (int i = 0; i < size; i++) {
			auto outdata = q.front();
			q.pop();

			for (int i = 0; i < 4; i++) {
				int nx = outdata.first + X[i], ny = outdata.second + Y[i];
				if (nx < 0 || ny<0 || nx> n - 1 || ny> m - 1 || arr[nx][ny]) continue;
				arr[nx][ny] = 1;
				q.push({ nx,ny });
			}
		}
		size = q.size();
		if (size) ans++;
	}


	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (!arr[i][j])
				ans = -1;

	printf("%d\n", ans);
}