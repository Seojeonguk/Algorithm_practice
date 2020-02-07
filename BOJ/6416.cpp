#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int u, v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int k = 1;; k++) {
		map<int, pair<int, int> > m;
		while (1) {
			scanf("%d %d", &u, &v);
			if (u < 1 || v < 1) break;
			if (m.find(u) == m.end()) {
				m[u].first = 1;
				m[u].second = 0;
			}
			else m[u].first++;

			if (m.find(v) == m.end()) {
				m[v].first = 0;
				m[v].second = 1;
			}
			else m[v].second++;
		}
		if (u == -1) break;

		int cnt = 0;
		bool chk = false;
		for (auto x : m) {
			if (x.second.second == 0) cnt++;
			if (x.second.second > 1 || cnt > 1) {
				chk = true;
				break;
			}
		}

		printf("Case %d is %sa tree.\n", k, chk || (m.size() && cnt == 0) ? "not " : "");
	}
}