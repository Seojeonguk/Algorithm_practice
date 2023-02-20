#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, n;
bool isVisit[5001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		memset(isVisit, false, sizeof isVisit);
		scanf("%d", &n);

		vector<pair<int, int> > v(n);
		for (int i = 0; i < n; i++)
			scanf("%d %d", &v[i].first, &v[i].second);

		sort(v.begin(), v.end());

		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (!isVisit[i]) {
				int prev_idx = i;
				ans++;
				isVisit[i] = true;
				for (int j = i + 1; j < n; j++) {
					if (v[prev_idx].first <= v[j].first && v[prev_idx].second <= v[j].second && !isVisit[j]) {
						isVisit[j] = true;
						prev_idx = j;
					}
				}
			}
		}

		printf("%d\n", ans);
	}
}
