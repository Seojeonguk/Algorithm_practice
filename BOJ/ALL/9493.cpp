#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int m, a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d %d", &m, &a, &b);
		if (!m) break;
		int t = abs(3600 * (1.*m / a) - 3600 * (1.*m / b));
		int ss = t % 60;
		t /= 60;
		int mm = t % 60;
		t /= 60;
		printf("%d:%02d:%02d\n", t, mm, ss);
	}
}