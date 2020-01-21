#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,x,g,tmp;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	tmp = n;
	for (int i = 0; i < n; i++) {
		scanf("%d", &g);
		if (g != -1) x += g;
		else tmp--;
	}
	printf("%.4lf\n", 1.*x / tmp);
}