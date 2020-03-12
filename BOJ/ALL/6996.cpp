#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int cnt[26], cnt2[26];
char arr[101], brr[101];
int length, length2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif]
	int test;
	cin >> test;
	while (test--) {
		bool ok = false;
		memset(cnt2, 0, sizeof cnt2);
		memset(cnt, 0, sizeof cnt);
		cin >> arr >> brr;
		length = strlen(arr);
		length2 = strlen(brr);

		if (length != length2) {
			cout << arr << " " << "&" << " " << brr << " are NOT anagrams.\n";
			continue;
		}

		for (int i = 0; i < length; i++) {
			cnt[arr[i] - 'a']++;
			cnt2[brr[i] - 'a']++;
		}
		for (int i = 0; i < 26; i++)
			if (cnt[i] != cnt2[i])
				ok = true;

		if (!ok) cout << arr << " " << "&" << " " << brr << " are anagrams.\n";
		else cout << arr << " " << "&" << " " << brr << " are NOT anagrams.\n";
	}
}