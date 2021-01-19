#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t,n, money[] = { 50000,10000,5000,1000,500,100,50,10 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);
		printf("#%d\n", tc);

		for (int i = 0; i < 8; i++) {
			printf("%d ", n / money[i]);
			n %= money[i];
		}
		puts("");
	}
}