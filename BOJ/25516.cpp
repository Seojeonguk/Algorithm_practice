#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k, x, y;
vector<int> v[100000];
bool isVisit[100000];
int apples[100000];

int solve() {
	int ret = 0;
	queue<pair<int, int>> q;
	isVisit[0] = true;
	q.push({ 0,0 });

	
	while (!q.empty()) {
		int dist = q.front().first;
		int now = q.front().second;
		q.pop();

		if (apples[now])
			ret++;

		if (dist == k) continue;

		for (int next : v[now]) {
			if (isVisit[next]) continue;
			isVisit[next] = true;
			q.push({ dist + 1, next });
		}
	}

	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	for (int i = 0; i < n - 1; i++) {
		scanf("%d %d", &x, &y);
		v[x].push_back(y);
		v[y].push_back(x);
	}

	for (int i = 0; i < n; i++)
		scanf("%d", &apples[i]);

	printf("%d\n", solve());
}
