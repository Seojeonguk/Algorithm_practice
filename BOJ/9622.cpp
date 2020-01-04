#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t,ans;
double le, wi, de, we;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for(scanf("%d",&t);t--;) {
		bool chk = true;
		scanf("%lf %lf %lf %lf", &le, &wi, &de, &we);
		if ((le > 56 || wi > 45 || de > 25) && (le + wi + de > 125)) chk = false;
		if (we > 7) chk = false;
		printf("%d\n", chk);
		ans += chk;
	}
	printf("%d\n", ans);
}