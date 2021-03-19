#include <iostream>
#include <cstdio>
#include<cstring>
using namespace std;

int n, m;
char arr[102][102];

int main() {
	memset(arr, '.', sizeof arr);
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i += 2) {
		for (int j = 0; j < m; j++)
			arr[i][j] = '#';
	}
	for (int i = 1; i < n; i += 2) {
		if (i % 4 == 1) arr[i][m - 1] = '#';
		else if (i % 4 == 3) arr[i][0] = '#';
	}
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			printf("%c", arr[i][j]);
		puts("");
	}
}