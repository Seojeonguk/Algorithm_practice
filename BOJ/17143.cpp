#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, k, r, c, s, d, z, ans;
struct d {
	int s, d, z; // 속력, 이동방향, 크기
}arr[102][102], brr[102][102];
int X[] = { -1,1,0,0 }, Y[] = { 0,0,1,-1 }; // 위,아래,오,왼


int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);

	for (int i = 0; i < k; i++) {
		scanf("%d %d %d %d %d", &r, &c, &s, &d, &z);
		arr[r - 1][c - 1] = { s,d - 1,z };
	}

	for (int king = 0; king < m; king++) {
		memset(brr, 0, sizeof brr);
		for (int i = 0; i < n; i++)
			if (arr[i][king].z != 0) {
				ans += arr[i][king].z;
				arr[i][king] = { 0,0,0 };
				break;
			}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j].z) {
					if (arr[i][j].d < 2) {
						int true_move = arr[i][j].s % ((n - 1) * 2);
						int moving = i;
						int dir = arr[i][j].d;

						while (true_move--) {
							if (moving == 0 && dir == 0) dir = 1;
							if (moving == n - 1 && dir == 1) dir = 0;
							moving += X[dir];
						}
						if (arr[i][j].z > brr[moving][j].z)
							brr[moving][j] = { arr[i][j].s,dir,arr[i][j].z };
					}
					else {
						int true_move = arr[i][j].s % ((m - 1) * 2);
						int moving = j;
						int dir = arr[i][j].d;

						while (true_move--) {
							if (moving == 0 && dir == 3) dir = 2;
							if (moving == m - 1 && dir == 2) dir = 3;
							moving += Y[dir];
						}
						if (arr[i][j].z > brr[i][moving].z)
							brr[i][moving] = { arr[i][j].s,dir,arr[i][j].z };
					}
					arr[i][j] = { 0,0,0 };
				}
			}
		}
		memcpy(arr, brr, sizeof brr);
	}

	printf("%d\n", ans);
}