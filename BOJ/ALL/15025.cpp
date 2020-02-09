#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int l,r;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &l, &r);
	if (!l && !r) puts("Not a moose");
	else if (l == r) printf("Even %d", l*2);
	else printf("Odd %d", max(l, r) * 2);
}