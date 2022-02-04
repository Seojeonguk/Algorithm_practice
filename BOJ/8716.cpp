#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int x[4], y[4];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 4; i++) scanf("%lld %lld", &x[i], &y[i]);

	long long int ans = 0;
	if (x[1] < x[2] || x[0] > x[3] || y[1]>y[2] || y[0] < y[3]) ans = 0;
	else ans = abs(min(x[1],x[3]) - max(x[0],x[2])) * abs(max(y[1],y[3]) - min(y[0],y[2]));
	printf("%lld\n", ans);
}