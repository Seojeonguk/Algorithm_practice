#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int arr[9][9];
int copy_arr[9][9];
int cpp_arr[9][9];
int n, m,ans;
int X[] = { 0,1,0,-1 }, Y[] = { 1,0,-1,0 };
vector<pair<int, int> > v;
queue<pair<int, int> > q;

void solve(int x ,int y,int cnt) {
	if (cnt == 3) {
		int mini_ans = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				copy_arr[i][j] = arr[i][j];

		for (int i = 0; i < v.size(); i++)
			q.push({ v[i].first,v[i].second });

		while (!q.empty()) {
			auto outque = q.front();
			q.pop();

			for (int i = 0; i < 4; i++) {
				pair<int,int> indata = { outque.first + X[i],outque.second + Y[i] };
				if (indata.first <0 || indata.second <0 || indata.first>n - 1 || indata.second>m - 1 || copy_arr[indata.first][indata.second]!=0) continue;
				copy_arr[indata.first][indata.second] = 2;
				q.push(indata);
			}
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (!copy_arr[i][j])
					mini_ans++;

		ans = max(ans, mini_ans);
		return;
	}
	for (int i = x; i < n; i++) {
		int j = (i!=x ? 0 : y);
		for ( ; j < m; j++)
			if (arr[i][j] == 0) {
				arr[i][j] = 1;
				solve(i, j,cnt + 1);
				arr[i][j] = 0;
			}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 2) v.push_back({ i,j });
		}

	solve(0,0,0);

	printf("%d\n", ans);
}