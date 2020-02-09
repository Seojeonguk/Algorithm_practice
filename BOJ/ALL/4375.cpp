#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;

ll x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%lld", &x) != EOF) {
		int cnt = 0;
		ll now = 0;
		while (1) {
			cnt++;
			now = now * 10 + 1;
			if (now && now%x == 0) break;
			now %= x;
		}
		printf("%d\n", cnt);
	}
}