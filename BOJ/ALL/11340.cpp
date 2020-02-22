#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t,a,b,c,tmp,chk;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d %d %d", &a, &b, &c);
		tmp = 9000- (a * 15 + b * 20 + c * 25);
		chk = tmp / 40 + (tmp % 40 ? 1 : 0);
		(chk >= 0 && chk <= 100) ? printf("%d\n", chk) : puts("impossible");
	}
}