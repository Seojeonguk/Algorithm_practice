#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int k, d;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &k, &d);
	int cnt = 0;
	int day = 0;
	while (1) {
		if (day + k > d) break;
		cnt++;
		day += k;
		k *= 2;
	}
	printf("%d\n", cnt);
}