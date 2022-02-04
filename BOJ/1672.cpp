#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
char ge[1000004];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %s", &n, ge);

	for (int i = n - 1; i > 0; i--) {
		if (ge[i-1] == 'A') {
			if (ge[i] == 'G') ge[i - 1] = 'C';
			else if (ge[i] == 'T') ge[i - 1] = 'G';
			else ge[i - 1] = 'A';
		}
		else if (ge[i - 1] == 'G') {
			if (ge[i] == 'A') ge[i - 1] = 'C';
			else if (ge[i] == 'C') ge[i - 1] = 'T';
			else if (ge[i] == 'T') ge[i - 1] = 'A';
		}
		else if (ge[i - 1] == 'C') {
			if (ge[i] == 'A') ge[i - 1] = 'A';
			else if (ge[i] == 'G') ge[i - 1] = 'T';
			else if (ge[i] == 'T') ge[i - 1] = 'G';
		}
		else {
			if (ge[i] == 'A' || ge[i] == 'C') ge[i - 1] = 'G';
			else if (ge[i] == 'G') ge[i - 1] = 'A';
		}
	}
	printf("%c", ge[0]);
}