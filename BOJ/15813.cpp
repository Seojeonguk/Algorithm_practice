#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, ans;
char name[103];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %s", &n,name);

	for (int i = 0; i < n; i++)
		ans += name[i] - 'A' + 1;

	printf("%d\n", ans);
}