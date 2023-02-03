#include<cstdio>
#include<cstring>
#include<algorithm>
using namespace std;
typedef long long ll;

int t, l, n;
int s[100005], e[100005], sum[100005];

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &l, &n);

		for (int i = 0; i < n; i++) {
			scanf("%d %d", &s[i], &e[i]);
			sum[i] = (i ? sum[i - 1] : 0) + e[i] - s[i];
		}

		int ans = -1;
		for (int i = 0; i < n; i++) {
			int slast = s[i] + l;
			auto idx = upper_bound(e, e + n - 1, slast) - e;

			int overlappingTime = sum[idx] - sum[i] + e[i] - s[i];

			if (e[idx] > slast)
				overlappingTime -= e[idx] - (s[idx] < slast ? slast : s[idx]);

			ans = max(ans, overlappingTime);
		}

		printf("#%d %d\n", tc, ans);
	}
}