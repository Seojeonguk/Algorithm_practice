#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, arr[300002],ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	for (int i = 0; i < n; i++) {
		int cnt = 0;
		for (int j = i + 1; j < n; j++) {
			if (arr[i] > arr[j]) cnt++;
			else break;
		}
		ans = max(ans, cnt);
	}
	printf("%d\n", ans);
}