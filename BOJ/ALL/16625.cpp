#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int p, q, s;
int gcd(int x, int y) {
	if (!y) return x;
	else return gcd(y, x%y);
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &p, &q, &s);
	printf("%s\n", p*q / gcd(p, q) > s ? "no" : "yes");
}