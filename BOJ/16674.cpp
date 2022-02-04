#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, cnt[10],chk;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	while (n) {
		chk++;
		cnt[n % 10]++;
		n /= 10;
	}
	if (cnt[0] + cnt[1] + cnt[2] + cnt[8] != chk) puts("0");
	else {
		if (cnt[0] && cnt[1] && cnt[2] && cnt[8]) {
			if (cnt[0] == cnt[1] && cnt[1] == cnt[2] && cnt[2] == cnt[8]) puts("8");
			else puts("2");
		}
		else puts("1");
	}
}