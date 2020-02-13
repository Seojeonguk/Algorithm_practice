#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int x, y;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) {
		scanf("%d", &x);
		y += (x == 1 ? 1 : -1);
	}

	printf("%d\n", y < 0 ? 2 : 1);
}