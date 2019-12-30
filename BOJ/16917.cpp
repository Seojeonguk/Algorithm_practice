#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, c, x,y,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d %d", &a, &b, &c, &x, &y);
	if (a + b > 2 * c) {
		ans = min(x, y)*c * 2;
		if (x < y) ans += min((y - x)*b,(y-x)*c*2);
		else ans += min((x - y)*a,(x-y)*c*2);
	}
	else ans = a * x + b * y;
	printf("%d\n", ans);
}