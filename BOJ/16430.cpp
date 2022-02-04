#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &a, &b);

	a = b - a;
	for(int i=a;i>=1;i--)
		if (!(b%i) && !(a%i)) {
			printf("%d %d\n", a/i, b/i);
			return 0;
		}
}