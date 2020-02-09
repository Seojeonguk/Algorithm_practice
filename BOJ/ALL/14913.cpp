#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, d, k;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &a, &d, &k);
	int tmp = (k - a) / d + 1;
	if ((k - a) % d == 0 && tmp > 0) printf("%d\n", tmp);
	else puts("X");
}