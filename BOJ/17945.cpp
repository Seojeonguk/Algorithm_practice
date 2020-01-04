#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &a, &b);

	int c = -a - sqrt(a*a - b);
	int d = -a + sqrt(a*a - b);
	if (c == d)  printf("%d\n", c);
	else printf("%d %d\n", min(c, d), max(c, d));
}