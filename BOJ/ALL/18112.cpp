#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char l[12];
bool visit[(1 << 10) + 1];
int s, d, sod[12];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 11; i++) sod[i + 1] = (1 << i);
	scanf("%s", l);
	for (int i = strlen(l) - 1, tmp = 1; i >= 0; i--, tmp <<= 1) s += (l[i] - '0')*tmp;
	scanf(" %s", l);
	for (int i = strlen(l) - 1, tmp = 1; i >= 0; i--, tmp <<= 1) d += (l[i] - '0')*tmp;
	queue<pair<int, int> > q;
	q.push({ s,0 });
	visit[s] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		if (outdata.first == d) {
			printf("%d\n", outdata.second);
			break;
		}
		if (outdata.first - 1 >= 0 && !visit[outdata.first - 1]) {
			visit[outdata.first - 1] = true;
			q.push({ outdata.first - 1,outdata.second + 1 });
		}
		if (outdata.first + 1 < 1024 && !visit[outdata.first + 1]) {
			visit[outdata.first + 1] = true;
			q.push({ outdata.first + 1,outdata.second + 1 });
		}

		int idx;
		for (idx = 10; idx >= 0 && sod[idx] > outdata.first; idx--) {}
		for (idx = idx - 1; idx >= 0; idx--) {
			int tmp = (outdata.first ^ sod[idx]);
			if (!visit[tmp]) {
				visit[tmp] = true;
				q.push({ tmp,outdata.second + 1 });
			}
		}
	}
}