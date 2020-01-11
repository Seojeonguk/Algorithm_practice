#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, k, c;

int solve(int now, int jin) {
	int ret = 0,gop=1;
	while (now) {
		if (now % 10 >= jin) return 0;
		ret += (now % 10 * gop);
		gop *= jin;
		now /= 10;
	}
	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d %d", &k, &c);
		printf("%d %d %d %d\n", k, solve(c, 8), c, solve(c, 16));
	}
}