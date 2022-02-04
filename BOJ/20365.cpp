#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,b,r;
char prob[500003];
char a;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %s", &n, prob);

	for (int i = 0; i < n; i++) {
		if (a != prob[i]) {
			a = prob[i];
			if (a == 'B') b++;
			else r++;
		}
	}

	printf("%d\n", 1 + min(b,r));
}