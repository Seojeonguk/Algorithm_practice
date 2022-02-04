#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, k,x,sum;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	for (int i = 0; i < k; i++) {
		scanf("%d", &x);
		sum += (x+1) / 2;
	}

	printf("%s\n", sum >= n ? "YES" : "NO");
}