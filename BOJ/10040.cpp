#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
vector<pair<int, int> > v;
int n, m,x,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		v.push_back({ x,0 });
	}

	for (int i = 0; i < m; i++) {
		scanf("%d", &x);
		for (int j = 0; j < n; j++) {
			if (v[j].first <= x) {
				v[j].second++;
				if (v[ans].second < v[j].second)
					ans = j;
				break;
			}
		}
	}
	printf("%d\n", ans + 1);
}