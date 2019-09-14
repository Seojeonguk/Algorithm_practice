#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b, v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &a, &b, &v);
	int ans = 1;
	v -= a;
	ans += v / (a - b);
	if (v % (a - b)) ans++;

	printf("%d\n", ans);
}