#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool coll[11];
int n, card[11], k;
set<int> s;

void solve(int sum, int cnt) {
	if (cnt == k) {
		s.insert(sum);
		return;
	}
	for (int i = 0; i < n; i++) {
		if (!coll[i]) {
			coll[i] = true;
			solve((card[i] >= 10 ? sum * 100 + card[i] : sum * 10 + card[i]), cnt + 1);
			coll[i] = false;
		}
	}

}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) scanf("%d", &card[i]);

	solve(0, 0);

	printf("%d\n", s.size());
}