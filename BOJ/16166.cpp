#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

set<int> s;
int n, k, an,des;
vector<int> v[11];
bool visit[11];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &k);
		for (int j = 0; j < k; j++) {
			scanf("%d", &an);
			v[i].push_back(an);
			if (!an && !visit[i])
				visit[i] = true;
		}
	}
	scanf("%d", &des);

	queue<pair<int, int> > q;
	for (int i = 0; i < n; i++) {
		if (!visit[i]) continue;
		for (int j = 0; j < v[i].size(); j++)
			q.push({ 0,v[i][j] });
	}

	int ans = -1;
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second == des) {
			ans = outdata.first;
			break;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i]) continue;
			for (int j = 0; j < v[i].size(); j++) 
				if (outdata.second == v[i][j])
					visit[i] = true;

			if (!visit[i]) continue;
			for (int j = 0; j < v[i].size(); j++)
				q.push({ outdata.first + 1,v[i][j] });
		}
	}

	printf("%d\n", ans);
}