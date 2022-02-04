#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t1, t2, t3;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &t1,&t2);

	int ans = 2;
	while (1) {
		t3 = t1 - t2;

		if (t3<0) {
			printf("%d\n", ans);
			break;
		}

		t1 = t2;
		t2 = t3;
		ans++;
	}
}