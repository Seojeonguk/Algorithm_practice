#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, now, cnt,x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	now = 1;
	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		if (now != x) cnt++;
		else now++;
	}
	printf("%d\n", cnt);
}