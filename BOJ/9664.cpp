#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, o;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &o);
	n--;
	int ano_da = o / n;
	if (o == ano_da*n) printf("%d %d\n",o+ano_da-1,o+ano_da);
	else printf("%d %d\n",o+ano_da,o+ano_da);
}