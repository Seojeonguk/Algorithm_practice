#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
#include<set>
using namespace std;

int n;
char arr[102][102];
int X[] = { -1,0,1,1,1,0,-1,-1 }, Y[] = { 1,1,1,0,-1,-1,-1,0 };

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d ", &n);

	for (int i = 0; i < n; i++) scanf(" %s", arr[i]);
	if (n < 3) {
		puts("0");
		return 0;
	}

	int ans = (n - 2)*(n - 2);

	for (int i = 1; i < n - 1; i++) {
		for (int j = 1; j < n - 1; j++) {
			bool chk = false;
			int nx, ny;
			for (int k = 0; k < 8; k++) {
				nx = i + X[k], ny = j + Y[k];
				if (arr[nx][ny] == '#') continue;
				if (arr[nx][ny] == '0') chk = true;
			}

			if (chk) ans--;
			else {
				for (int k = 0; k < 8; k++) {
					nx = i + X[k], ny = j + Y[k];
					if (arr[nx][ny] == '#' || arr[nx][ny] == '0') continue;
					arr[nx][ny]--;
				}
			}
		}
	}

	printf("%d\n", ans);
}