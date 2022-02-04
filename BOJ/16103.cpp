#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
long long int k;
char str[100002];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %lld", &n, &k);
	k = k % 3;
	scanf(" %s", str);
	if (k == 0) printf("%s", str);
	else {
		for (int i = 0; i < n / 4; i++) printf("%c", str[i]);
		for (int i = n / 4 * (4 - k); i < n; i++) printf("%c", str[i]);
		for (int i = n / 4; i < n / 4 * (4 - k); i++) printf("%c", str[i]);
	}
}