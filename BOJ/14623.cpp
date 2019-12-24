#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char b1[33], b2[33],ans[34];
int tmp1, tmp2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf(" %s %s ", b1, b2);

	for (int i = strlen(b1) - 1, j = 1; i >= 0; i--, j *= 2) tmp1 += (b1[i] - '0')*j;
	for (int i = strlen(b2) - 1, j = 1; i >= 0; i--, j *= 2) tmp2 += (b2[i] - '0')*j;
	long long int x = (long long int)tmp1 * tmp2;

	for (int i = 0; x > 0; i++, x /= 2) ans[i] = x % 2 + +'0';

	reverse(ans, ans+strlen(ans));
	printf("%s", ans);
}