#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int m,a,b,k,ans2=1;
bool ans1;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &m);
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &a, &b, &k);
		if (k == 1) ans1 = !ans1;
		ans2 = b * (ans2 / a);
	}
	printf("%d %d", ans1, ans2);
}