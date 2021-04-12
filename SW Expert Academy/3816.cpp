#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;


int t;
char s1[100002], s2[100002];
int s1_cnt[27], s2_cnt[27];

int chk() {
	for (int i = 0; i < 26; i++)
		if (s1_cnt[i] != s2_cnt[i])
			return 0;
	return 1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		memset(s1_cnt, 0, sizeof s1_cnt);
		memset(s2_cnt, 0, sizeof s2_cnt);
		scanf(" %s %s ", s1, s2);
		
		int i = 0;
		for (i = 0; s1[i]; i++) {
			s1_cnt[s1[i] - 'a']++;
			s2_cnt[s2[i] - 'a']++;
		}
		int s1_length = i;

		int ans = chk();

		for (; s2[i]; i++) {
			s2_cnt[s2[i - s1_length] - 'a']--;
			s2_cnt[s2[i] - 'a']++;
			ans += chk();
		}

		printf("#%d %d\n", tc, ans);
	}
}