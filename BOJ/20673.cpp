#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int p,q;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &p, &q);

	if (p <= 50 && q <= 10) puts("White");
	else if (q >= 30) puts("Red");
	else puts("Yellow");
}