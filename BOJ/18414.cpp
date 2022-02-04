#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int x, l, r, ans=999999;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &x, &l, &r);

	for (int i = l; i <= r; i++) {
		if (abs(x - ans) > abs(x - i))
			ans = i;
	}
	printf("%d\n", ans);
}