#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
using ll = long long;

int N, t[10];
ll v[10];
bool first[10];
string a[50];
pair<ll, int> b[10];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cin >> N;
	for (int i = 0; i < N; i++) 
		cin >> a[i];

	for (int i = 0; i < N; i++) {
		first[a[i][0] - 'A'] = true;
		ll k = 1;
		for (int j = a[i].size() - 1; j >= 0; j--) {
			v[a[i][j] - 'A'] += k;
			k *= 10;
		}
	}

	for (int i = 0; i < 10; i++)
		b[i] = { v[i],i };
	sort(b, b + 10);

	if (b[0].first != 0 && first[b[0].second]) {
		int idx = 1;
		while (first[b[idx].second])
			idx++;
		auto tmp = b[idx];
		for (int i = idx - 1; i >= 0; i--) 
			b[i + 1] = b[i];
		b[0] = tmp;
	}

	for (int i = 9; i >= 0; i--) {
		if (!b[i].first) 
			break;
		t[b[i].second] = i;
	}
	ll ans = 0;

	for (int i = 0; i < N; i++) {
		string s = a[i], ret;
		for (int j = 0; j < s.size(); j++) 
			ret += t[s[j] - 'A'] + '0';
		ans += stoll(ret);
	}
	cout << ans;
}