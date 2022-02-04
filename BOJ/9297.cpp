#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, a, b;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int c = 0; c < t; c++,puts("")) {
		scanf("%d %d", &a, &b);

		printf("Case %d: ",c+1);
		if (!a) printf("0");
		else {
			if (a / b) printf("%d ", a / b);
			if (a%b) printf("%d/%d", a%b, b);
		}
	}
}