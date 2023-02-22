#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, k;
pair<int, int> p[1001];
map<double, int> slopes;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);

	for (int i = 0; i < n; i++)
		scanf("%d %d", &p[i].first, &p[i].second);

	int ans = 0;
	for (int i = 0; i < k; i++) {
		for (int j = 0; j < n; j++) {
			int x = (i & 1 ? m - p[j].first : p[j].first) + i * m;
			double slope = 1.0 * x / p[j].second;
			slopes[slope]++;
			ans = max(ans, slopes[slope]);
		}
	}

	printf("%d\n", ans);
}
