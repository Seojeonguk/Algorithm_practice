#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool chk[3001][3001];
int arr[3][4], ans;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 4; i++) {
		scanf("%d", &arr[0][i]);
		arr[0][i] += 1000;
	}

	for (int i = arr[0][0]; i < arr[0][2]; i++)
		for (int j = arr[0][1]; j < arr[0][3]; j++)
			chk[i][j] = true;

	for (int i = 0; i < 4; i++) {
		scanf("%d", &arr[1][i]);
		arr[1][i] += 1000;
	}

	for (int i = arr[1][0]; i < arr[1][2]; i++)
		for (int j = arr[1][1]; j < arr[1][3]; j++)
			chk[i][j] = true;

	for (int i = 0; i < 4; i++) {
		scanf("%d", &arr[2][i]);
		arr[2][i] += 1000;
	}

	for (int i = arr[2][0]; i < arr[2][2]; i++)
		for (int j = arr[2][1]; j < arr[2][3]; j++)
			chk[i][j] = false;

	for (int i = 0; i <= 2000; i++)
		for (int j = 0; j <= 2000; j++)
			if (chk[i][j]) ans++;

	printf("%d\n", ans);
}