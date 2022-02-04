#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
double d;
int H, V;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%lf %d %d", &d, &H, &V);
		if (!H) break;
		double w = 16. * d / sqrt(337);
		double h = 9. * w / 16;
		printf("Horizontal DPI: %.2lf\n", 1.*H / w);
		printf("Vertical DPI: %.2lf\n", 1.*V / h);
	}
}