#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, arr[9][9];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		for (int i = 0; i < 9; i++) 
			for (int j = 0; j < 9; j++)
				scanf("%d", &arr[i][j]);

		bool chk = true;
		for (int i = 0; i < 9; i++) {
			int garo = 0, sero = 0;
			for (int j = 0; j < 9; j++) {
				garo += arr[i][j];
				sero += arr[j][i];
			}
			if (garo != 45 || sero != 45) {
				chk = false;
				break;
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int sum = 0;
				for (int k = i * 3; k < i * 3+3; k++) {
					for (int l = j * 3; l < j * 3+3; l++) {
						sum += arr[k][l];
					}
				}
				if (sum != 45) {
					chk = false;
					break;
				}
			}
		}

		printf("#%d %d\n", tc, chk);
	}
}