#include<cstdio>
#include<cstring>
using namespace std;
typedef long long ll;

int t, n, p, x;
int sum[1000001], isStudy[1000001];

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		memset(sum, 0, sizeof sum);
		memset(isStudy, 0, sizeof isStudy);
		scanf("%d %d", &n, &p);

		for (int i = 0; i < n; i++) {
			scanf("%d", &x);
			isStudy[x] = 1;
		}

		sum[0] = isStudy[0];
		for (int i = 1; i < 1000001; i++) {
			sum[i] = sum[i - 1] + isStudy[i];
		}

		int l = 1, r = 400000;

		while (l <= r) {
			int mid = (l + r) / 2;

			bool isPossible = false;
			for (int i = 0; i + mid - 1 < 1000001; i++) {
				int r = sum[i + mid - 1] - (i == 0 ? 0 : sum[i - 1]);
				if (r + p >= mid) {
					isPossible = true;
					break;
				}
			}

			if (isPossible) l = mid + 1;
			else r = mid - 1;
		}

		printf("#%d %d\n", tc, r);
	}
}