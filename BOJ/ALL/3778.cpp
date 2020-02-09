#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,acnt[26],bcnt[26];
char a[60], b[60];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf(" %d ", &n);

	for (int i = 0; i < n; i++) {
		fgets(a, sizeof(a), stdin);
		fgets(b, sizeof(b), stdin);
		int ans = 0;
		memset(acnt, 0, sizeof acnt);
		memset(bcnt, 0, sizeof bcnt);
		for (int j = 0; a[j]; j++) acnt[a[j] - 'a']++;
		for (int j = 0; b[j]; j++) bcnt[b[j] - 'a']++;
		for (int j = 0; j < 26; j++) ans += abs(acnt[j] - bcnt[j]);

		printf("Case #%d: %d\n", i + 1, ans);
	}
}