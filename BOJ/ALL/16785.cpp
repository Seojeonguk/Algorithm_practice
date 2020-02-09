#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, c,ans,sum;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &a, &b, &c);
	for (int i = 1; sum < c; ans=i++) {
		sum += a;
		if (!(i % 7)) sum += b;
	}
	printf("%d\n", ans);
}