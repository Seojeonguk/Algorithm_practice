#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int m, arr[52], k, all;
double nck[2502][2502];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &m);

	for (int i = 0; i < m; i++) {
		scanf("%d", &arr[i]);
		all += arr[i];
	}

	scanf("%d", &k);

	nck[0][0] = nck[1][0] = nck[1][1] = 1;

	for (int i = 2; i <= 2500; i++) {
		nck[i][0] = nck[i][i] = 1;
		for (int j = 1; j < i; j++)
			nck[i][j] = nck[i - 1][j - 1] + nck[i - 1][j];
	}

	double sum = 0;
	for (int i = 0; i < m; i++) sum += nck[arr[i]][k];

	printf("%.12lf\n", sum / nck[all][k]);
}