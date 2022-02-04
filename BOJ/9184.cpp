#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int x, y, z;
long long int dp[102][102][102];

long long int solve(int a, int b, int c) {

	if (a <= 0 || b <= 0 || c <= 0)
		return 1;

	long long int& ret = dp[a+50][b+50][c+50];
	if (ret > 0)
		return ret;

	if (a > 20 || b > 20 || c > 20)
		ret = solve(20, 20, 20);
	else if (a < b && b < c)
		ret = solve(a, b, c - 1) + solve(a, b - 1, c - 1) - solve(a, b - 1, c);
	else
		ret = solve(a - 1, b, c) + solve(a - 1, b - 1, c) + solve(a - 1, b, c - 1) - solve(a - 1, b - 1, c - 1);

	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d %d", &x, &y, &z);
		if (x == -1 && y == -1 && z == -1)
			break;
		printf("w(%d, %d, %d) = %lld\n", x, y, z,solve(x,y,z));
	}
}