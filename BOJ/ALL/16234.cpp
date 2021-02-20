#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, l, r,ans;
int arr[52][52];
bool visit[52][52];
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &l, &r);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &arr[i][j]);

	while (1) {
		
		memset(visit, 0, sizeof visit);
		bool moving = false;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					vector<pair<int, int > > v;
					queue<pair<int, int> > q;
					int sum = 0;
					int cnt = 0;
					q.push({ i,j });
					visit[i][j] = true;

					while (!q.empty()) {
						auto outdata = q.front();
						q.pop();

						v.push_back({ outdata.first,outdata.second });
						sum += arr[outdata.first][outdata.second];
						cnt++;

						for (int i = 0; i < 4; i++) {
							int nx = outdata.first + X[i];
							int ny = outdata.second + Y[i];

							if (nx<0 || ny<0 || nx>n - 1 || ny>n - 1 || visit[nx][ny]) continue;
							int diff = abs(arr[outdata.first][outdata.second] - arr[nx][ny]);
							if (diff < l || diff>r) continue;
							visit[nx][ny] = true;
							q.push({ nx,ny });
						}
					}
					if (arr[i][j]!=sum) {
						moving = true;
						int s = v.size();
						for (int i = 0; i < s; i++) 
							arr[v[i].first][v[i].second] = sum / cnt;
					}
				}
			}
		}

		if (!moving) break;
		ans++;
	}

	printf("%d\n", ans);
}