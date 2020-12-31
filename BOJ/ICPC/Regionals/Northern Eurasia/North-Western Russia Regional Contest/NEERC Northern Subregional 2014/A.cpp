#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int hh, mm, n;
int cnt[10] = { 6,2,5,5,4,5,6,3,7,6 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	while (hh != 24) {
		int sum = cnt[hh / 10] + cnt[hh % 10] + cnt[mm / 10] + cnt[mm % 10];
		if (sum == n) {
			printf("%02d:%02d\n", hh, mm);
			return 0;
		}
		mm++;
		if (mm >= 60) {
			hh++;
			mm = 0;
		}
	}
	puts("Impossible");
}