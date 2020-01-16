#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n1,n2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n1, &n2);
	int c = n1, rc = n1;
	for (int i = 0; i <= 180; i++) {
		if (c == n2) printf("%d", i);
		else if (rc == n2) printf("%d", -i);
		c = (c + 1) % 360;
		rc = (360 + rc - 1) % 360;
	}
}