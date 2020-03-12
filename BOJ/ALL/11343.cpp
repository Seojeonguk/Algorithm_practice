#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, m, cnt;
char c[103][103];
bool visit[103][103];
pair<int, int> ans[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		memset(visit, 0, sizeof visit);
		scanf("%d %d", &n, &m);

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= m; j++) scanf(" %c ", &c[i][j]);
		bool chk = false;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!visit[i][j] && !chk) {
					cnt = 0;
					ans[0].first = i, ans[0].second = j;
					for (int k = i + 1;k<=n && (c[k][j] == c[i][j]); k++) {
						cnt++;
						ans[cnt].first = k, ans[cnt].second = j;
						if(cnt==2) {
							chk = true;
							break;
						}
					}
					if (chk) {
						for (int k = 0; k < 3; k++) printf("%d %d ", ans[k].first, ans[k].second);
						break;
					}
					cnt = 0;
					for (int k = j + 1;k<=m&&(c[i][k] == c[i][j]); k++) {
						cnt++;
						ans[cnt].first = i, ans[cnt].second = k;
						if (cnt == 2) {
							chk = true;
							break;
						}
					}
					if (chk) {
						for (int k = 0; k < 3; k++) printf("%d %d ", ans[k].first, ans[k].second);
						break;
					}
				}
			}
		}
		if (!chk) printf("no set found");
		printf("\n");
	}
}