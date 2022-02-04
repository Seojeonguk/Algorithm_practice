#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,ans,bonus;
char S[10005];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %s", &n, S);

	for (int i = 1; i <= n; i++) {
		if (S[i-1] == 'O') ans += i + bonus++;
		else bonus = 0;
	}
	printf("%d\n", ans);
}