#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t;
int arr[10][10];
bool visit[10],chk;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int pqpq = 1; pqpq <= t; pqpq++) {
		chk = true;
		for (int i = 0; i < 9; i++) {
			memset(visit, 0, sizeof visit);
			for (int j = 0; j < 9; j++) {
				scanf("%d", &arr[i][j]);
				if (visit[arr[i][j]]) chk = false;
				visit[arr[i][j]] = true;
			}
		}
		printf("Case %d: ", pqpq);
		
		for (int i = 0; i < 9; i++) {
			memset(visit, 0, sizeof visit);
			for (int j = 0; j < 9; j++) {
				if (visit[arr[j][i]]) chk = false;
				visit[arr[j][i]] = true;
			}
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				memset(visit, 0, sizeof visit);
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						if (visit[arr[k][l]]) chk = false;
						visit[arr[k][l]] = true;
					}
				}
			}
		}

		if (!chk) puts("INCORRECT");
		else puts("CORRECT");
	}
}
