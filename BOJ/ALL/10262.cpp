#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, c, d;
double arr[2];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 2; i++) {
		scanf("%d%d%d%d", &a, &b, &c, &d);
		arr[i] = (b*(b + 1) / 2. - a * (a - 1) / 2) / (b - a + 1) + (d*(d + 1) / 2. - c * (c - 1) / 2) / (d - c + 1);
	}
	printf("%lf %lf\n", arr[0], arr[1]);
	if (arr[0] < arr[1]) puts("Emma");
	else if (arr[0] > arr[1]) puts("Gunnar");
	else puts("Tie");
}