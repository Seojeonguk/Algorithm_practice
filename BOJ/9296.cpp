#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n;
char k[103], r[103];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for(int tc= 1;tc<=t;tc++) {
		int cnt = 0;
		scanf("%d", &n);
		scanf(" %s %s ", k,r);
		for (int i = 0; i < n; i++)
			if (k[i] != r[i])
				cnt++;

		printf("Case %d: %d\n", tc, cnt);
	}
}