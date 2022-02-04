#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, x[4], y[4];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		for (int i = 0; i < 4; i++) scanf("%d %d", &x[i], &y[i]);
		int poster = (y[1] - y[0]) * (x[1] - x[0]);
		int x_ = max(min(x[1], x[3]) - max(x[0], x[2]),0);
		int y_ = max(min(y[1], y[3]) - max(y[0], y[2]), 0);
		printf("%d\n", poster-x_*y_);
	}
}