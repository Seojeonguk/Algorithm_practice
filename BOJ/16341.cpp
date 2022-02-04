#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b, c, d;
int arr[9][9];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a, &b, &c, &d);

	for (int i = 1; i <= 8; i++) 
		for (int j = 1; j <= 8; j++) 
			arr[i][j] = (i+j) % 2;

	puts(arr[a][b] != arr[c][d] ? "white" : "black");
}