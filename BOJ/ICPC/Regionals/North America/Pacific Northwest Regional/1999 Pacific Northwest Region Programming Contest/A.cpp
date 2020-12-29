#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int p, e, i, d;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int tc = 1;; tc++) {
		scanf("%d %d %d %d", &p, &e, &i, &d);
		if (p == -1) break;

		int ans = 0;
		while (1) {
			if ((d-p)%23==0 && (d-e)%28==0 && (d-i)%33==0 && ans) break;
			d++;
			ans++;
		}

		printf("Case %d: the next triple peak occurs in %d days.\n",tc,ans);
	}
}