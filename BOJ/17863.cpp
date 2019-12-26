#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) {
		scanf("%1d", &n);
		if (n != 5) {
			puts("NO");
			return 0;
		}
	}
	puts("YES");
}