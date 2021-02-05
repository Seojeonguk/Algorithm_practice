#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, c, s,idx,cnt;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &c, &s);
	cnt = (s == 1 ? 1 : 0);
	for (int i = 0; i < c; i++) {
		int x;
		scanf("%d", &x);
		if (x == 1) idx = (idx + 1+n) % n;
		else idx = (idx - 1+n) % n;
		if (s - 1 == idx) cnt++;
	}
	printf("%d\n", cnt);
}