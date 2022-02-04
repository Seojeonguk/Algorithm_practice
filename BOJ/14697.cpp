#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, c, n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a, &b, &c, &n);

	for (int i = 0; i*a <= n; i++)
		for (int j = 0; i*a + j * b <= n; j++)
			for(int k=0;i*a+j*b+k*c<=n;k++)
				if (i*a + b * j + k * c == n) {
					puts("1");
					return 0;
				}
	puts("0");
}