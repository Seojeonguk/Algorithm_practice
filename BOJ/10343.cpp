#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

string word;
ll k, fac[17];
int cnt[26];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	ios::sync_with_stdio(false);
	cin.tie(0);

	fac[0] = 1;
	for (int i = 1; i < 17; i++)
		fac[i] = fac[i - 1] * i;

	while (1) {
		memset(cnt, 0, sizeof cnt);
		cin >> word >> k;
		if (word == "#") {
			break;
		}
		sort(word.begin(), word.end());

		ll total = fac[word.size() - 1];

		for (int i = 0; i < word.size(); i++)
			cnt[word[i] - 'A']++;

		for (int i = 0; i < 26; i++)
			if (cnt[i])
				total /= fac[cnt[i]];

		int idx = 0;

		string ans;
		while (idx < word.size()) {
			for (int i = 0; i < 26; i++) {
				if (cnt[i]) {
					cnt[i]--;
					total = fac[word.size() - 1 - idx];

					for (int j = 0; j < 26; j++)
						if (cnt[j])
							total /= fac[cnt[j]];

					if (total < k) {
						k -= total;
						cnt[i]++;
					}
					else {
						ans += ('A' + i);
						break;
					}
				}
			}
			idx++;
		}
		cout << ans << "\n";
	}
} 
