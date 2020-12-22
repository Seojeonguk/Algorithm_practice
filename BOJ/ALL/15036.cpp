#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

map<int, double> m;
int n;
double ans;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	m.insert({ 0,2 });
	m.insert({ 1,1 });
	m.insert({ 2,0.5 });
	m.insert({ 4,0.25 });
	m.insert({ 8,0.125 });
	m.insert({ 16,0.0625 });

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		int x; scanf("%d", &x);
		ans += m[x];
	}
	printf("%lf\n", ans);
}