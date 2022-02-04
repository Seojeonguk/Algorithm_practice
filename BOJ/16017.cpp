#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, c, d;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a, &b, &c, &d);

	if ((a == 8 || a == 9) && (d == 8 || d == 9) && b == c) puts("ignore");
	else puts("answer");
}