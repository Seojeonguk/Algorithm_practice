#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, p, ret;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif

	scanf("%d%d%d", &n, &m, &p);

	for (int i = 1; i <= n; ++i)
		for (int j = 1; j <= m; ++j)
			if ((i + j) * 2 >= p)
				ret += (n - i + 1) * (m - j + 1);

	printf("%d\n", ret);
}