#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x,y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &x, &y);
	if (x > 0) {
		if (y > 0) puts("1");
		else puts("4");
	}
	else {
		if (y > 0) puts("2");
		else puts("3");
	}
}