#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, _in, _out, now,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &now);
	ans = now;
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &_in, &_out);
		now = now + _in - _out;
		if (now < 0) {
			puts("0");
			return 0;
		}
		ans = max(ans, now);
	}
	printf("%d\n", ans);
}