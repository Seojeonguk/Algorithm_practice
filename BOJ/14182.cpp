#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int income;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &income);
		if (!income) break;
		if (income <= 1000000) printf("%d\n", income);
		else if (income <= 5000000) printf("%d\n", income - income / 10);
		else printf("%d\n", income - income / 5);
	}
}