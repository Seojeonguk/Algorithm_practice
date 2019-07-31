#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int tc = 0; tc < t; tc++) {
		long long a, b, c;
		scanf("%lld %lld %lld", &a, &b, &c);
		printf("%lld\n", (a + b + c) / (long long)2);
	}
}