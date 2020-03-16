#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t,n,m,sx,sy,dx,dy;
char painting[104][104],st[10],c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for(int tc= 1;tc<=t;tc++) {
		memset(painting, '.', sizeof painting);
		scanf("%d %d", &n, &m);
		for (int i = 0; i < m; i++) {
			scanf(" %s %d %d %d %d %c ", st, &sy, &sx, &dy, &dx, &c);
			sx--, sy--;
			if (st[0] == 'F') {
				for (int i = sx; i < sx+dx; i++)
					for (int j = sy; j < sy+dy; j++)
						painting[i][j] = c;
			}
			else {
				for (int i = sx; i < sx + dx; i++) painting[i][sy] = painting[i][sy+dy-1] = c;
				for (int i = sy; i < sy + dy; i++) painting[sx][i] =painting[sx+dx-1][i] = c;
			}
		}

		printf("Case %d:\n", tc);
		for (int i = n-1; i>=0; i--,puts(""))
			for (int j = 0; j < n; j++)
				printf("%c", painting[i][j]);
	}
}