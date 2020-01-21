#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, ans;
int a[502][502];
const int b[19][4][2] = {
	{ {0,0}, {0,1}, {1,0}, {1,1} }, 
	{ {0,0}, {0,1}, {0,2}, {0,3} }, 
	{ {0,0}, {1,0}, {2,0}, {3,0} },
	{ {0,0}, {0,1}, {0,2}, {1,0} },
	{ {0,2}, {1,0}, {1,1}, {1,2} },
	{ {0,0}, {1,0}, {1,1}, {1,2} },
	{ {0,0}, {0,1}, {0,2}, {1,2} },
	{ {0,0}, {1,0}, {2,0}, {2,1} },
	{ {0,0}, {0,1}, {1,1}, {2,1} },
	{ {0,0}, {0,1}, {1,0}, {2,0} },
	{ {0,1}, {1,1}, {2,0}, {2,1} },
	{ {0,0}, {1,0}, {1,1}, {2,1} }, 
	{ {0,1}, {1,0}, {1,1}, {2,0} },
	{ {0,1}, {0,2}, {1,0}, {1,1} },
	{ {0,0}, {0,1}, {1,1}, {1,2} },
	{ {0,0}, {0,1}, {0,2}, {1,1} }, 
	{ {0,1}, {1,0}, {1,1}, {1,2} },
	{ {0,1}, {1,0}, {1,1}, {2,1} },
	{ {0,0}, {1,0}, {1,1}, {2,0} }
};

void solve(int x, int y) {
	for (int i = 0; i < 19; i++) {
		int res = 0;
		for (int j = 0; j < 4; j++) {
			int nx = x + b[i][j][0];
			int ny = y + b[i][j][1];
			if (0 <= nx && nx < n && 0 <= ny && ny < m) {
				res += a[nx][ny];
			}
		}
		if (ans < res) ans = res;
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			scanf("%d", &a[i][j]);
	
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			solve(i, j);

	printf("%d\n", ans);
}