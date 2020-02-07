#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, x, s, cnt, ans, sum = 1;
map<int, int> m[101];
bool visit[1000002];
int chk[1000000];
vector<int> v;
set<int> se;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 2; i <= 1000000; i++) {
		if (!visit[i]) {
			v.push_back(i);
			for (int j = i * 2; j <= 1000000; j += i) visit[j] = true;
		}
	}
	s = v.size();
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		for (int j = 0; j < s; j++) {
			if (x%v[j] == 0) {
				se.insert(v[j]);
				cnt = 0;
				while (x%v[j] == 0) {
					cnt++;
					x /= v[j];
				}
				m[i][v[j]] = cnt;
				chk[v[j]] += cnt;
			}
			if (x == 1) break;
		}
	}

	for (auto it : se) {
		for (int i = 0; i < chk[it] / n; i++) sum *= it;
		for (int i = 0; i < n; i++) {
			int tmp = chk[it] / n - (m[i].find(it) == m[i].end() ? 0 : m[i][it]);
			ans += (tmp > 0 ? tmp : 0);
		}
	}
	printf("%d %d\n", sum, ans);
}