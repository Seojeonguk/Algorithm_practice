#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
bool chk[32769];
int n,x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		chk[x] = true;
	}

	for(int i=1;i<=n;i++)
		if (!chk[i]) {
			printf("%d\n", i);
			break;
		}
}