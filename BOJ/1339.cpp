#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, cnt[26], ans, sz;
bool chk[10];
set<int> s;
vector<int> v;
char arr[11][11];

void solve(int idx) {
	if (idx == s.size()) {
		int sum = 0, sum_tmp = 0;
		for (int i = 0; i < n; i++) {
			sum = 0;
			for (int j = 0; arr[i][j]; j++)
				sum = sum * 10 + cnt[arr[i][j] - 'A'];
			sum_tmp += sum;
		}
		ans = max(ans, sum_tmp);
		return;
	}
	for (int j = 0; j < 10; j++) {
		if (!chk[j]) {
			chk[j] = true;
			cnt[v[idx]] = j;
			solve(idx + 1);
			cnt[v[idx]] = -1;
			chk[j] = false;
		}
	}
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%s", arr[i]);

		for (int j = 0; arr[i][j]; j++)
			s.insert(arr[i][j] - 'A');
	}
	sz = s.size();
	for (auto x : s) v.push_back(x);
	solve(0);

	printf("%d\n", ans);
}