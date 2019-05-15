#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int l, k,fast_ans,late_ans;
int arr[1000002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int T;
	scanf("%d", &T);

	while (T--) {
		scanf("%d %d", &l, &k);
		fast_ans = late_ans = 0;
		for (int i = 0; i < k; i++) {
			scanf("%d", &arr[i]);
			fast_ans = max(fast_ans, min(arr[i], l - arr[i]));
			late_ans = max(late_ans, max(arr[i], l - arr[i]));
		}
		printf("%d %d\n", fast_ans, late_ans);
	}
}