#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
string a, b;
ll k;
bool chk(string x) {
	if (x.length() > 19) return true;
	else if (x.length() < 19) return false;
	else return x.compare("9223372036854775807") > 0;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cin >> a >> b >> k;
	if (a[0] == '0' || b[0] == '0') puts("0");
	else if (chk(a) || chk(b)) puts("overflow");
	else {
		ll a1 = stoll(a),b1 = stoll(b);
		if (a1 > (k / b1)) puts("overflow");
		else printf("%lld\n", a1*b1);
	}
}