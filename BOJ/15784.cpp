#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,x,y,charm[1002][1002],max_charm;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n,&x,&y);

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++) {
			scanf("%d", &charm[i][j]);
			if (i == x || j == y) max_charm = max(max_charm, charm[i][j]);
		}

	printf("%s\n", max_charm == charm[x][y] ? "HAPPY" : "ANGRY");

}