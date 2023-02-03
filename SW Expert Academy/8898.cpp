#include<cstdio>
#include<algorithm>
using namespace std;

int t, n, m, c1, c2, horse;
int cows[500002];

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &m);

		scanf("%d %d", &c1, &c2);

		for (int i = 0; i < n; i++)
			scanf("%d", &cows[i]);

		sort(cows, cows + n);

		int minDistance = 1e9;
		int cnt = 0;
		int distance = 0;
		for (int i = 0; i < m; i++) {
			scanf("%d", &horse);
			auto idx = lower_bound(cows, cows + n - 1, horse) - cows;

			distance = abs(cows[idx] - horse);
			if (distance < minDistance) {
				minDistance = distance;
				cnt = 1;
			}
			else if (distance == minDistance)
				cnt++;

			if (idx > 0) {
				distance = abs(cows[idx - 1] - horse);
				if (distance < minDistance) {
					minDistance = distance;
					cnt = 1;
				}
				else if (distance == minDistance)
					cnt++;
			}
		}

		printf("#%d %d %d\n", tc, minDistance + abs(c1 - c2), cnt);
	}
}