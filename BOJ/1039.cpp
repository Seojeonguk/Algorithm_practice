#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, k, s, tmp[9], ans = -1, a, idx, sum;
bool visit[1000002][11];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);
	int chk = n;
	while (chk) {
		s++;
		chk /= 10;
	}
	chk = 1;
	for (int i = 1; i < s; i++) chk *= 10;
	queue<pair<int, int> > q;
	q.push({ n,0 });
	visit[n][0] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second == k) {
			if (outdata.first >= chk) ans = max(ans, outdata.first);
			continue;
		}

		for (int i = 0; i < s; i++) {
			for (int j = i + 1; j < s; j++) {
				memset(tmp, 0, sizeof tmp);
				idx = s - 1;
				a = outdata.first;
				while (a) {
					tmp[idx--] = a % 10;
					a /= 10;
				}
				sum = 0;
				swap(tmp[i], tmp[j]);
				for (int q = 0; q < s; q++)
					sum = sum * 10 + tmp[q];
				if (visit[sum][outdata.second + 1]) continue;
				if (chk > sum) continue;
				visit[sum][outdata.second + 1] = true;
				q.push({ sum,outdata.second + 1 });
			}
		}
	}

	printf("%d\n", ans);
}