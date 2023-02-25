#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int k, n, m, cow, a, b, ans;
int cows[1010], cnt[1010];
bool isVisit[1010];
vector<int> v[1010];

void solve(int st) {
	memset(isVisit, false, sizeof isVisit);
	queue<int> q;
	q.push({ st });
	isVisit[st] = true;

	while (!q.empty()) {
		int now = q.front();
		q.pop();

		cnt[now]++;

		for (int next : v[now]) {
			if (isVisit[next]) continue;
			isVisit[next] = true;
			q.push(next);
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &k, &n, &m);

	for (int i = 0; i < k; i++) 
		scanf("%d", &cows[i]);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &a, &b);
		v[a].push_back(b);
	}

	for (int i = 0; i < k; i++)
		solve(cows[i]);

	for (int i = 1; i <= n; i++)
		if (cnt[i] == k)
			ans++;

	printf("%d\n", ans);
}
