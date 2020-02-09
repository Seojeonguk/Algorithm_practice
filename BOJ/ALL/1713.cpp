#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, x, min_cnt, min_y, min_idx;
struct d { int w, cnt, y; }d[22];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d", &x);
		bool ok = true;
		min_cnt = min_y = min_idx = 99999;

		for (int j = 0; j < n; j++) {
			if (x == d[j].w) {
				d[j].cnt++;
				ok = false;
				break;
			}
			if (min_cnt > d[j].cnt) {
				min_cnt = d[j].cnt;
				min_y = d[j].y;
				min_idx = j;
			}
			else if (min_cnt == d[j].cnt) {
				if (min_y > d[j].y) {
					min_y = d[j].y;
					min_idx = j;
				}
			}
		}

		if (ok)d[min_idx].w = x, d[min_idx].cnt = 1, d[min_idx].y = i;
	}
	priority_queue<int> q;
	for (int i = 0; i < n; i++)
		if (d[i].w)q.push(-d[i].w);

	while (!q.empty()) {
		printf("%d ", -q.top());
		q.pop();
	}
}