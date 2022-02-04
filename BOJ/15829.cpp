#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
int n;
char arr[52];
ll MOD = 1234567891, r = 31, now = 1, ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %s", &n, arr);

	for (int i = 0; i < strlen(arr); i++) {
		int value = arr[i] - 'a'+1;
		ans = (ans + value * now) % MOD;
		now = (now*31)%MOD;
	}

	printf("%lld\n", ans);
}