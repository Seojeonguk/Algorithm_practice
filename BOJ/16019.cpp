#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int chk[6][6];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 4; i++) scanf("%d", &chk[5][i]);

	for (int i = 0; i < 5; i++,puts("")) 
		for (int j = 0; j < 5; j++) {
			chk[i][j] = (i < j ? chk[i][j - 1] + chk[5][j - 1] : chk[j][i]);
			printf("%d ", chk[i][j]);
		}
}