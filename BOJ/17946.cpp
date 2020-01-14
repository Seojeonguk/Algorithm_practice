#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int X[5], Y[5];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 5; i++) scanf("%d", &X[i]);
	for (int i = 0; i < 5; i++) scanf("%d", &Y[i]);

	for (int i = 0; i < 5; i++)
		if (X[i] + Y[i] != 1) {
			puts("N");
			return 0;
		}
	puts("Y");
}