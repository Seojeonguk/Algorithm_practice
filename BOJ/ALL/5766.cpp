#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m,x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &n, &m);
		if (!n && !m) break;
		vector<pair<int, int> > v(10002);
		for (int i = 0; i < n*m; i++) {
			scanf("%d", &x);
			v[x].second = x;
			v[x].first++;
		}
		sort(v.begin(), v.end());

		v.pop_back();

		stack<int> s;
		int t = v[v.size() - 1].first;
		for (int i = v.size() - 1; i >= 0; i--)
			if (v[i].first == t)
				s.push(v[i].second);

		while (!s.empty()) {
			printf("%d ", s.top());
			s.pop();
		}
		puts("");
	}
}