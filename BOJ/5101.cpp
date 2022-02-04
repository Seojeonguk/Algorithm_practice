#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d %d", &a, &b, &c);
		if (!a && !b && !c) break;
		if ((c - a) % b != 0 || (c - a) / b < 0) puts("X");
		else printf("%d\n", (c - a) / b + 1);
	}
}