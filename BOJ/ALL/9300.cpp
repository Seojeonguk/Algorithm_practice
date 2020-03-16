#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t;
double h, seta;
const double pi = 3.1415926535897932384626433832795028841971693993751;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for(int tc= 1;tc<=t;tc++) {
		scanf("%lf %lf", &h, &seta);
		double tanseta = tan(seta / 180 * pi);
		printf("Case %d: %lf\n", tc, abs(h*(1-tanseta)/tanseta));
	}
}