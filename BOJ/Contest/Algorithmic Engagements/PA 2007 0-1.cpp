#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a[4];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 4; i++) scanf("%d", &a[i]);

	printf("%d\n", a[0] * a[1] + a[2] * a[3]);
}