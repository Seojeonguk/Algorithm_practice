#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,gil[30],x,y;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	int ans = 0;
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);
		gil[i] = x + y;
	}

	for (int i = 0; i < n; i++)
		ans += abs(gil[i] - gil[(i + 1) % n]);

	printf("%d\n", ans);
}