#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, k, ans, arr[5], s, y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &s, &y);
		if (y <= 2) arr[0]++;
		else if (y <= 4) {
			if (s) arr[1]++;
			else arr[2]++;
		}
		else {
			if (s)arr[3]++;
			else arr[4]++;
		}
	}
	for (int i = 0; i < 5; i++)
		ans += arr[i] / k + (arr[i] % k ? 1 : 0);

	printf("%d\n", ans);
}