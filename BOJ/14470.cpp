#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int jj[5],ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 5; i++) scanf("%d", &jj[i]);

	if (jj[0] < 0) {
		ans += (-jj[0] * jj[2]) + jj[3];
		jj[0] = 0;
	}
	ans += (jj[1]-jj[0]) * jj[4];

	printf("%d\n", ans);
}