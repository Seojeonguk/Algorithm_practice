#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int k1, k2, k3;
char o1, o2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %c %d %c %d", &k1, &o1, &k2, &o2, &k3);

	int x1 = 0;
	if (o1 == '+') x1 = k1 + k2;
	else if (o1 == '-') x1 = k1 - k2;
	else if (o1 == '*') x1 = k1 * k2;
	else if (o1 == '/') x1 = k1 / k2;

	int ans1 = 0;
	if (o2 == '+') ans1 = x1 + k3;
	else if (o2 == '-') ans1 = x1 - k3;
	else if (o2 == '*') ans1 = x1 * k3;
	else if (o2 == '/') ans1 = x1 / k3;

	int x2 = 0;
	if (o2 == '+') x2 = k2 + k3;
	else if (o2 == '-') x2 = k2 - k3;
	else if (o2 == '*') x2 = k2 * k3;
	else if (o2 == '/') x2 = k2 / k3;

	int ans2 = 0;
	if (o1 == '+') ans2 = k1 + x2;
	else if (o1 == '-') ans2 = k1 - x2;
	else if (o1 == '*') ans2 = k1 * x2;
	else if (o1 == '/') ans2 = k1 / x2;

	printf("%d\n%d\n", min(ans1, ans2), max(ans1, ans2));
}