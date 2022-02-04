#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a,x,y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &a);
		if (!a) break;
		int ans = 1;
		for (int i = 0; i < a; i++) {
			scanf("%d %d", &x, &y);
			ans *= x;
			ans -= y;
		}
		printf("%d\n", ans);
	}
}