#include <iostream>
using namespace std;
int n, m, x, y;
int visit[202][202];
int main() {
	scanf("%d %d", &n, &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		visit[x][y] = 1;
		visit[y][x] = 2;
	}

	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (visit[i][k] && visit[k][j] && visit[i][k] == visit[k][j])
					visit[i][j] = visit[i][k];
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		int up = 0, down = 0;
		for (int j = 1; j <= n; j++) {
			if (visit[i][j] == 1) up++;
			else if (visit[i][j] == 2) down++;
		}
		printf("%d %d\n", down, up);
	}
}