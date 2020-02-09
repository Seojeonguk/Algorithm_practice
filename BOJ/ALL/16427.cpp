#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, s, max_t,t;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &s);

	for (int i = 0; i < n; i++) {
		scanf("%d", &t);
		max_t = max(max_t, t);
	}
	max_t *= s;
	printf("%d\n", (max_t + 999) / 1000);
}