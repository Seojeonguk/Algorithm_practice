#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, x, y;
int owes[10001];
bool isVisit[10001];
vector<int> friends[10001];

bool solve(int st) {
	queue<int> q;
	isVisit[st] = true;
	q.push(st);

	int ret = 0;
	while (!q.empty()) {
		int now_friend = q.front();
		q.pop();

		ret += owes[now_friend];

		for (int next_friend : friends[now_friend]) {
			if (isVisit[next_friend]) continue;
			isVisit[next_friend] = true;
			q.push(next_friend);
		}
	}

	return ret == 0;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++)
		scanf("%d", &owes[i]);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		friends[x].push_back(y);
		friends[y].push_back(x);
	}

	bool isPossible = true;
	for (int i = 0; i < n; i++) {
		if (!isVisit[i])
			isPossible &= solve(i);
	}

	puts(isPossible ? "POSSIBLE" : "IMPOSSIBLE");
}
