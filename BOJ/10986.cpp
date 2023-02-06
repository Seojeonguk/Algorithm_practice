#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, cost,sum[1000001];
ll cnt, res[1001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf("%d", &cost);
		sum[i] = (cost + (i ? sum[i - 1] : 0)) % m;

		if (!sum[i])
			cnt++;

		res[sum[i]]++;	
	}

	for (int i = 0; i < m; i++)
		cnt += res[i] * (res[i] - 1) / 2;

	printf("%lld\n", cnt);
}
