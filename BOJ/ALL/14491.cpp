#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t;
char ans[10];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	int idx = 0;
	while (t) {
		ans[idx++] = t % 9 + '0';
		t /= 9;
	}
	reverse(ans, ans + idx);
	printf("%s\n", ans);
}