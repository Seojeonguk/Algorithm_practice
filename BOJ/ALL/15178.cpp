#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, a, b, c;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d %d %d", &a, &b, &c);
		printf("%d %d %d %s\n", a, b, c, a + b + c == 180 ? "Seems OK" : "Check");
	}
}