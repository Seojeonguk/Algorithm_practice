#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int l, p, v,idx;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d %d", &l, &p, &v);
		if (!v) break;

		printf("Case %d: %d\n", ++idx,v / p * l + min(v % p,l));
	}
}