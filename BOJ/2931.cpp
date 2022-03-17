#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;
char arr[27][27];
int X[] = { -1,0,1,0 }, Y[] = { 0,1,0,-1 };
struct d {
	int x, y, dir;
}st, de;
int visit[26][26];
char pi[] = { '+','|','-','1','2','3','4' };
pair<int, int> ans = { -2,-2 };

//위 오른쪽 아래 왼쪽
int direction(int a, char c) {
	int ret = -1;
	if (c == '|') {
		if (a == 0 || a == 2) ret = a;
	}
	else if (c == '-') {
		if (a == 1 || a == 3) ret = a;
	}
	else if (c == '+') ret = a;
	else if (c == '1') {
		if (a == 0) ret = 1;
		else if (a == 3) ret = 2;
	}
	else if (c == '2') {
		if (a == 2) ret = 1;
		else if (a == 3) ret = 0;
	}
	else if (c == '3') {
		if (a == 1) ret = 0;
		else if (a == 2) ret = 3;
	}
	else if (c == '4') {
		if (a == 1) ret = 2;
		else if (a == 0) ret = 3;
	}
	return ret;
}

pair<int, int> solve() {
	memset(visit, 0, sizeof visit);
	queue<d> q;
	q.push(st);

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		visit[outdata.x][outdata.y]++;
		if (arr[outdata.x][outdata.y] == 'Z') return { -1,-1 };
		else if (arr[outdata.x][outdata.y] == '.') return { de.x,de.y };
		else if (outdata.dir == -1) return { 0,0 };

		if (arr[outdata.x][outdata.y] == 'M') {
			for (int i = 0; i < 4; i++) {
				de.x = outdata.x + X[i];
				de.y = outdata.y + Y[i];
				if (de.x < 0 || de.y < 0 || de.x>n - 1 || de.y > m - 1) continue;
				if (ans.first == de.x && ans.second == de.y)continue;
				if (arr[de.x][de.y] == 'Z') continue;
				if (arr[de.x][de.y] != '.') {
					de.dir = direction(i, arr[de.x][de.y]);
					q.push(de);
				}
			}
		}
		else {
			de.x = outdata.x + X[outdata.dir];
			de.y = outdata.y + Y[outdata.dir];
			if (de.x < 0 || de.y < 0 || de.x>n - 1 || de.y > m - 1) continue;
			de.dir = direction(outdata.dir, arr[de.x][de.y]);
			q.push(de);
		}
	}
	return { 0,0 };
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf(" %s", arr[i]);
		for (int j = 0; arr[i][j]; j++)
			if (arr[i][j] == 'M') st.x = i, st.y = j, st.dir = 5;
			else if (arr[i][j] == 'Z') de.x = i, de.y = j;
	}
	ans = solve();
	for (int i = 0; i < 7; i++) {
		arr[ans.first][ans.second] = pi[i];

		auto chk = solve();
		bool plussecond = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == '+') {
					if (visit[i][j] != 2)
						plussecond = false;
				}
			}
		}
		if (!plussecond) continue;
		if (chk.first == -1 && chk.second == -1) {
			printf("%d %d %c\n", ans.first + 1, ans.second + 1, pi[i]);
			break;
		}
	}
}