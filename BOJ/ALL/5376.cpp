#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
int t, x_cnt, y_cnt;
ll x, y;
ll gcd(ll x, ll y) {
	if (!y) return x;
	return gcd(y, x%y);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (scanf("%d", &t); t--;) {
		x = y = x_cnt = y_cnt = 0;
		string s;
		cin >> s;

		bool chk = false;
		s.erase(0, 2);
		for (auto a : s) {
			if (a == '(' || a == ')') chk = true;
			else {
				if (chk) {
					y_cnt++;
					y = y * 10 + a - '0';
				}
				else {
					x_cnt++;
					x = x * 10 + a - '0';
				}
			}
		}
		ll up = 0;
		if (chk) {
			ll aa = 1;
			for (int i = 0; i < y_cnt; i++) aa *= 10;
			up = aa * x + y;
			up -= x;
		}
		else up = x;
		ll down = chk ? 0 : 1;

		if (chk)
			for (int i = 0; i < y_cnt; i++) down = down * 10 + 9;
		for (int i = 0; i < x_cnt; i++) down *= 10;
		ll g = gcd(up, down);
		printf("%lld/%lld\n", up / g, down / g);
	}
}