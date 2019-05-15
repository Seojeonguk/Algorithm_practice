#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
struct dat {
	int x, y, d;
};
vector<dat> v;
int n, m,si,ans = 99999;
int arr[9][9],chk[9][9],asdf[9][9];
void w(int x, int y) { while (x != -1 && chk[x][y] != 99999) chk[x--][y]++; }
void s(int x, int y) { while (x != n && chk[x][y] != 99999) chk[x++][y]++; }
void a(int x, int y) { while (y != -1 && chk[x][y] != 99999) chk[x][y--]++; }
void d(int x, int y) { while (y != m && chk[x][y] !=99999) chk[x][y++]++; }

void ww(int x, int y) { while (x != -1 && chk[x][y] !=99999) chk[x--][y]--; }
void ss(int x, int y) { while (x != n && chk[x][y] != 99999) chk[x++][y]--; }
void aa(int x, int y) { while (y != -1 && chk[x][y] != 99999) chk[x][y--]--; }
void dd(int x, int y) { while (y != m && chk[x][y] != 99999) chk[x][y++]--; }

void solve(int idx){

	
	if (idx == si) {
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (!chk[i][j])
					cnt++;
		if (ans > cnt) {
			ans = cnt;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					asdf[i][j] = chk[i][j];
		}
		return;
	}

	int x = v[idx].x, y = v[idx].y, t = v[idx].d;
	if (t == 1) {
		w(x, y);
		solve(idx + 1);
		ww(x, y);

		s(x, y);
		solve(idx + 1);
		ss(x, y);

		a(x, y);
		solve(idx + 1);
		aa(x, y);

		d(x, y);
		solve(idx + 1);
		dd(x, y);
	}
	else if (t == 2) {
		a(x, y);
		d(x, y);
		solve(idx + 1);
		aa(x, y);
		dd(x, y);

		w(x, y);
		s(x, y);
		solve(idx + 1);
		ww(x, y);
		ss(x, y);
	}
	else if (t == 3) {
		w(x, y);
		d(x, y);
		solve(idx + 1);
		ww(x, y);

		s(x, y);
		solve(idx + 1);
		dd(x, y);

		a(x, y);
		solve(idx + 1);
		ss(x, y);

		w(x, y);
		solve(idx + 1);
		ww(x, y);
		aa(x, y);
	}
	else if (t == 4) {
		a(x, y);
		w(x, y);
		d(x, y);
		solve(idx + 1);
		aa(x, y);

		s(x, y);
		solve(idx + 1);
		ww(x, y);

		a(x, y);
		solve(idx + 1);
		dd(x, y);

		w(x, y);
		solve(idx + 1);

		ww(x, y);
		aa(x, y);
		ss(x, y);
	}
	else if (t == 5) {
		a(x, y);
		w(x, y);
		s(x, y);
		d(x, y);
		solve(idx + 1);
	}
}



int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			scanf("%d", &arr[i][j]);
			if (arr[i][j] == 6) chk[i][j] = 99999;
			if (arr[i][j] && arr[i][j] < 6) v.push_back({ i,j,arr[i][j] });
		}
	}

	si = v.size();

	solve(0);

	printf("%d\n", ans);

	
}