#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, cnt;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i < n; i++) {
		for (int j = i; j < n; j++) {
			int tmp = n - (i + j);
			if (tmp < j) break;
			if (i + j > tmp) cnt++;
		}
	}
	printf("%d\n", cnt);
}