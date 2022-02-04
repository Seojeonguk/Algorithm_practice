#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int m, p, l, e, r, s, n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d %d %d %d %d %d %d", &m, &p, &l, &e, &r, &s, &n) == 7) {
		for (int i = 0; i < n; i++) {
			int temp = p;
			p = l / r;
			l = m * e;
			m = temp / s;
		}

		printf("%d\n", m);
	}
}