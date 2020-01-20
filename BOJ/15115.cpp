#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int k, p, x;
double ans=99999999.;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &k, &p, &x);

	for (int i = 1; i <= k * p; i++) {
		double tmp = 1.*x*i + 1.*k*p / i;
		ans = min(ans, tmp);	
	}
	printf("%.3lf\n", ans);
}