#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t;
char a[1003], b[1003];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		int cnt[26] = { 0, };
		scanf(" %s %s", a, b);
		int a_size = strlen(a);
		int b_size = strlen(b);
		if (a_size != b_size) {
			puts("Impossible");
			continue;
		}
		for (int i = 0; i < a_size; i++) cnt[a[i] - 'a']++;
		for (int i = 0; i < b_size; i++) cnt[b[i] - 'a']--;

		bool chk = true;
		for (int i = 0; i < 26; i++)
			if (cnt[i] != 0) {
				puts("Impossible");
				chk = false;
				break;
			}
		if (chk) puts("Possible");
	}
}