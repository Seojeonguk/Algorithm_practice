#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, k;
int paskal[35][35];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 35; i++)
		for (int j = 0; j < 35; j++)
			paskal[i][j] = 1;
	scanf("%d %d", &n, &k);

	for (int i = 3; i <= n; i++)
		for (int j = 2; j < i; j++)
			paskal[i][j] = paskal[i - 1][j-1] + paskal[i - 1][j];

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++)
			printf("%d ", paskal[i][j]);
		puts("");
	}

	printf("%d", paskal[n][k]);
}