#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, a_, b, b_, c, c_;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d.%d %d.%d %d.%d", &a, &a_, &b, &b_, &c, &c_);
	a = a * 100 + a_;
	b = b * 100 + b_;
	c = c * 100 + c_;
	bool chk = true;
	for (int i = 0; i <= max(a / b, a / c); i++) {
		if (a < b*i) break;
		if ((a - b * i) % c == 0) {
			chk = false;
			printf("%d %d\n", i, (a - b * i) / c);
		}
	}
	if (chk) puts("none");
}