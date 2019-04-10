#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
int n,arr[102][102];
int ans = 1,max_,tmp_ans;
bool visit[102][102];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			scanf("%d", &arr[i][j]);
			max_ = max(max_, arr[i][j]);
		}
	for (int now = 1; now <= max_; now++) {
		tmp_ans = 0;
		memset(visit, false, sizeof visit);
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (arr[i][j] <= now)
					visit[i][j] = true;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visit[i][j]) {
					tmp_ans++;
					queue<pair<int, int> > q;
					q.push({ i,j });
					visit[i][j] = true;
					while (!q.empty()) {
						auto outdata = q.front();
						q.pop();

						
						for (int k = 0; k < 4; k++) {
							auto indata = outdata;
							indata.first += X[k];
							indata.second += Y[k];

							if (indata.first<0 || indata.second<0 || indata.first>n - 1 || indata.second > n - 1 || visit[indata.first][indata.second]) continue;
							visit[indata.first][indata.second] = true;
							q.push(indata);
						}


					}
				}
			}
		}
		ans = max(ans, tmp_ans);
	}

	printf("%d\n", ans);
}