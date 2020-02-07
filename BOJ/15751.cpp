#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a, b, x, y,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &a, &b, &x, &y);

	printf("%d\n", min(abs(b - a), min(abs(a - x) + abs(b - y), abs(a - y) + abs(x - b))));
}