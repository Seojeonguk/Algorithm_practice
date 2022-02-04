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

	for(int i=1;i<=n;i++) 
		if (i*(i + 1) / 2 >= n) {
			ans = i;
			break;
		}

	int tmp = n - (ans)*(ans - 1) / 2;
	printf("%d %d\n", ans - tmp + 1, tmp);
}