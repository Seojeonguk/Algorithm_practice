#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n;
char c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (scanf("%d", &t); t--;) {
		scanf("%d %c", &n, &c);
		for (int i = 0; i < n; i++) printf("%c", c);
		puts("");
	}
}