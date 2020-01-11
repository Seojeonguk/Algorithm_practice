#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, sa, sb, sc,a,b,c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d %d %d", &a, &b, &c);

		sa += a, sb += b, sc += c;

		int m = min(sa, min(sb, sc));
		if (m >= 30) {
			sa -= m, sb -= m, sc -= m;
			printf("%d\n", m);
		}
		else puts("NO");
	}
}