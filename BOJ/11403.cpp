#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
int arr[102][102];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			scanf("%d", &arr[i][j]);

	
	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i][k] && arr[k][j]) {
					arr[i][j] = 1;
				}
			}
		}
	}

	

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			printf("%d ",arr[i][j]);
		puts("");
	}
}