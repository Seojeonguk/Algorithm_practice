#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;



int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int tc;
	scanf("%d", &tc);
	while (tc--) {
		char ph[4], op[3];
		double a;
		scanf("%s %s %lf", ph, op, &a);
		a = -log10(a);
		printf("%.2lf\n", ph[0] == 'H' ? a : 14-a);
	}
}