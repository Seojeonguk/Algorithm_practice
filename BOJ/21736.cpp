#ifdef _DEBUG
	#include "bits_stdc++.h"
	#else
	#include "bits/stdc++.h"
	#endif
	#pragma warning(disable:4996)
	using namespace std;
	
	int n, m, sx, sy, ans;
	char campus[602][602];
	bool visit[602][602];
	int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
	queue<pair<int, int> > q;
	
	int main() {
	#ifdef _CONSOLE 
		freopen("sample.txt", "r", stdin);
	#endif
		scanf("%d %d", &n, &m);
	
		for (int i = 0; i < n; i++) {
			scanf(" %s", &campus[i]);
			for (int j = 0; j < m; j++)
				if (campus[i][j] == 'I')
					sx = i, sy = j;
		}
	
		q.push({ sx,sy });
		visit[sx][sy] = true;
	
		while (!q.empty()) {
			auto outdata = q.front();
			q.pop();
			
			if (campus[outdata.first][outdata.second] == 'P')
				ans++;
	
			for (int i = 0; i < 4; i++) {
				int nx = outdata.first + X[i];
				int ny = outdata.second + Y[i];
	
				if (nx<0 || ny<0 || nx>n - 1 || ny>m - 1 || visit[nx][ny] || campus[nx][ny] == 'X') continue;
				visit[nx][ny] = true;
				q.push({ nx,ny });
			}
		}
	
		if (!ans) puts("TT");
		else printf("%d\n", ans);
	}