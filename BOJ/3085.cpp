#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,ans;
char board[55][55];

void solve() {
	for (int i = 1; i <= n; i++) {
		for (int j = 2,cnt=1; j <= n; j++) {
			if (board[i][j-1] == board[i][j]) cnt++;
			else cnt = 1;
			ans = max(ans, cnt);
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1,cnt=1; j <= n; j++) {
			if (board[j-1][i] == board[j][i]) cnt++;
			else cnt = 1;
			ans = max(ans, cnt);
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			scanf(" %c", &board[i][j]);

	for(int i=1;i<=n;i++) 
		for (int j = 1; j <= n; j++) {
			swap(board[i][j], board[i + 1][j]);
			solve();
			swap(board[i][j], board[i + 1][j]);

			swap(board[i][j], board[i][j+1]);
			solve();
			swap(board[i][j], board[i][j+1]);
		}

	printf("%d\n", ans);
}