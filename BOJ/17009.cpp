#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x, a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 3; i >= 1; i--) {
		scanf("%d", &x);
		a += x * i;
	}
	for (int i = 3; i >= 1; i--) {
		scanf("%d", &x);
		b += x * i;
	}
	if (a > b) puts("A");
	else if (a < b)puts("B");
	else puts("T");
}