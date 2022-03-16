#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b, c, cnt;
bool chk[1000001];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &a, &b, &c);

	int temp = c;
	int mod = (c ? 1 : 10);
	while (temp) {
		temp /= 10;
		mod *= 10;
	}

	while (1) {
		a *= b;
		a %= mod;
		cnt++;
		if (chk[a]) {
			puts("NIKAD");
			break;
		}
		chk[a] = true;
		if (a == c) {
			printf("%d\n", cnt);
			break;
		}
	}
}