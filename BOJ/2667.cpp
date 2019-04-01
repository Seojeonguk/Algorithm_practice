#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, arr[26][26], ans;
int X[] = { 0,1,0,-1 }, Y[] = { 1,0,-1,0 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%1d", &arr[i][j]);

	queue<pair<int, int> > q;
	vector<int> v;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (arr[i][j]) {
				q.push({ i,j });
				arr[i][j] = 0, ans = 0;
				while (!q.empty()) {
					auto outdata = q.front();
					q.pop();
					ans++;

					for (int i = 0; i < 4; i++) {
						int nx = outdata.first + X[i], ny = outdata.second + Y[i];
						if (nx < 0 || ny < 0 || nx > n - 1 || ny>n - 1 || !arr[nx][ny])continue;
						q.push({ nx,ny });
						arr[nx][ny] = 0;
					}
				}
				v.push_back(ans);
			}
		}
	}

	sort(v.begin(), v.end());
	printf("%d\n", v.size());
	for (int i = 0; i < (int)v.size(); i++)
		printf("%d\n", v[i]);
}