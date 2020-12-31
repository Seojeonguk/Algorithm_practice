#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, x, y, m;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for(int tc=1;;tc++) {
		scanf("%d", &n);
		if (n < 0) break;

		long long int summ = 0, sumx = 0, sumy = 0;
		for (int i = 0; i < n; i++) {
			scanf("%d %d %d", &x, &y, &m);
			summ += m;
			sumx += m * y;
			sumy += m * x;
		}

		printf("Case %d: %.2lf %.2lf\n",tc, 1. * sumy / summ, 1. * sumx / summ);
	}
}