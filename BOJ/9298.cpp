#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n;
double x, y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int k = 1; k <= t; k++) {
		double arr[4] = { 1000,1000,-1000,-1000 };
		scanf("%d", &n);
		for (int i = 0; i < n; i++) {
			scanf("%lf %lf", &x, &y);
			arr[0] = min(arr[0], x);
			arr[1] = min(arr[1], y);
			arr[2] = max(arr[2], x);
			arr[3] = max(arr[3], y);
		}
		printf("Case %d: Area %.9lf, Perimeter %lf\n", k, (arr[3] - arr[1])*(arr[2] - arr[0]), (arr[3] - arr[1]) * 2 + (arr[2] - arr[0]) * 2);
	}
}