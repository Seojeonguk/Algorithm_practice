#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int st, de, n,cost,city,city_num,ans=1001;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &st, &de, &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &cost, &city);
		bool start = false;
		for (int j = 0; j < city; j++) {
			scanf("%d ", &city_num);
			if (city_num == st) start = true;
			if (start && city_num == de) {
				ans = min(ans, cost);
			}
		}
	}
	printf("%d\n", ans);
}