#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int w, n, p, hp, ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &w, &n, &p);

	for (int i = 0; i < p; i++) {
		scanf("%d", &hp);
		if (w <= hp && hp <= n) ans++;
	}
	printf("%d\n", ans);
}