#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int e, s, m;

int main() {
#ifdef _CONSOLE
	freopen("sample.txt", "r", stdin);
#endif
	int x = 1;
	scanf("%d %d %d", &e, &s, &m);
	while (1) {
		if ((x % 15 ? x % 15 : 15) == e && (x % 28 ? x % 28 : 28) == s && (x % 19 ? x % 19 : 19) == m)
			break;
		x++;
	}
	printf("%d\n", x);
}