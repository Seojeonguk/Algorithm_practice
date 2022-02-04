#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double d, vf, vg;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%lf %lf %lf", &d, &vf, &vg) != EOF) {
		double dist = sqrt(144 + d * d);
		double tf = 12 / vf;
		double tg = dist / vg;
		if (tg <= tf) puts("S");
		else puts("N");
	}
}