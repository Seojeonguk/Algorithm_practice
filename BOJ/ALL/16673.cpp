#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int c, k, p, ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &c, &k, &p);

	for (int i = 1; i <= c; i++)
		ans += k * i + p * i*i;
	printf("%d\n", ans);
}