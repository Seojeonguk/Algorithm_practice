#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, m;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d %d", &n, &m);
		if (n < 12 || m < 4) puts("-1");
		else printf("%d\n", 11 * m + 4);
	}
}