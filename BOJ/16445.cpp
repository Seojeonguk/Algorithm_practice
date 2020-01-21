#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,x,tmp;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	tmp = n;
	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		if (x == 1) tmp--;
	}
	printf("%d\n", tmp);
}