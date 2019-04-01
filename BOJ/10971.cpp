#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, ans = 987654321;
int arr[11][11];
struct d { int st, now, chk, sum; };
queue<d> q;
d outdata;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &arr[i][j]);

	for (int i = 0; i < n; i++)
		q.push({ i,i,0,0 });

	while (!q.empty()) {
		outdata = q.front();
		q.pop();

		if (outdata.st == outdata.now && outdata.chk) {
			if (outdata.chk == (1 << n) - 1)
				ans = min(ans, outdata.sum);
			continue;
		}

		for (int i = 0; i < n; i++) {
			if (arr[outdata.now][i] && !(outdata.chk  & (1 << i))) {
				q.push({ outdata.st,i,outdata.chk | (1 << i) , outdata.sum + arr[outdata.now][i] });
			}
		}
	}
	printf("%d\n", ans);
}