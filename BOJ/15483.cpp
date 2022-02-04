#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char A[1002], B[1002];
int dp_table[1002][1002];

int dp(int a_idx, int b_idx) {
	int& ret = dp_table[a_idx][b_idx];
	if (ret != -1) return ret;
	if (a_idx == strlen(A)) return ret = strlen(B) - b_idx;
	if (b_idx == strlen(B)) return ret = strlen(A) - a_idx;

	ret = dp(a_idx + 1, b_idx + 1) + (A[a_idx] != B[b_idx]);
	ret = min(ret, dp(a_idx + 1, b_idx) + 1);
	ret = min(ret, dp(a_idx, b_idx + 1) + 1);

	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%s %s", A, B);
	memset(dp_table, -1, sizeof dp_table);
	printf("%d\n", dp(0, 0));
}