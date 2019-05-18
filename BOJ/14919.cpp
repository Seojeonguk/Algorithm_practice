#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int m, tmp;
int q = 100000000;
double n;
int arr[1002];



int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &m);

	int t = q / m;

	while (scanf("%lf",&n) ==1) {
		tmp = (int)(n * 100000000);
		arr[tmp / t]++;
	}

	for (int i = 0; i < m; i++)
		printf("%d ", arr[i]);
}