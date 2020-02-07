#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, k, cnt;
bool chk[1004];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	for (int i = 2; i <= n; i++)
		if (!chk[i])
			for (int j = i; j <= n; j += i)
				if (!chk[j]) {
					cnt++;
					chk[j] = true;
					if (cnt == k) {
						printf("%d\n", j);
						return 0;
					}
				}
}