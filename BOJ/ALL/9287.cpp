#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, k;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for(int tc = 1;tc<=t;tc++) {
		bool chk = true;
		scanf("%d", &n);
		for (int i = 0; i < n; i++) {
			scanf("%d", &k);
			if (k == 0 || k == 100 || k == 1) chk = false;
		}
		printf("Case %d: %s\n", tc, chk ? "Standing" : "Fallen");
	}
}