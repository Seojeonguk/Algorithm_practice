#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int q, a;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &q);
	while (q--) {
		scanf("%d", &a);
		if ((a & -a) == a) puts("1");
		else puts("0");
	}
}