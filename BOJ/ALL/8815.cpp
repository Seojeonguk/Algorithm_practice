#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n;
char hektor[14] = {0,'A','B','C','B','C','D','C','D','A','D','A','B','A'};


int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d", &n);
		if (n < 14) printf("%c\n", hektor[n]);
		else printf("%c\n", hektor[((n - 2) % 12) + 2]);
	}
}