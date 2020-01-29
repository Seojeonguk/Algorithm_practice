#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n1, n2, n12;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n1, &n2, &n12);

	printf("%d\n", (n1 + 1)*(n2 + 1) / (n12 + 1) - 1);
}