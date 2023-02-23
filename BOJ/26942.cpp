#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, ans;
map<string, int> name_idxs;
vector<int> v[101];
bool isVisit[101];
string name, name2;

void solve(int x) {
	queue<int> q;
	isVisit[x] = true;
	q.push(x);

	while (!q.empty()) {
		int now = q.front();
		q.pop();

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
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> name;
		name_idxs[name] = i;
	}

	cin >> m;

	for (int i = 0; i < m; i++) {
		cin >> name >> name2;
		int name_idx = name_idxs[name];
		int name2_idx = name_idxs[name2];

		v[name_idx].push_back(name2_idx);
		v[name2_idx].push_back(name_idx);
	}

	for (int i = 0; i < n; i++) {
		if (!isVisit[i]) {
			ans++;
			solve(i);
		}
	}

	printf("%d\n", ans);
}
