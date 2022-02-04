#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	int cnt = 1;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			printf("%d", cnt++);
			if (j != m - 1) printf(" ");
		}
		puts("");
	}
}