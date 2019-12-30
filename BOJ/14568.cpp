#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 2; n - i >= 3; i += 2)
		for (int j = 1; n - i - j >= j+2; j++)
			ans++;
	printf("%d\n", ans);
}