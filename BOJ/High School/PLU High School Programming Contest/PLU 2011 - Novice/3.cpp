#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double ans;
int a, b, c, d, e, test;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif]
	cin >> test;

	while (test--)
	{
		cin >> a >> b >> c >> d >> e;
		ans = a * 350.34 + b * 230.90 + c * 190.55 + d * 125.30 + e * 180.90;
		printf("$%.2lf\n", ans);
	}
}