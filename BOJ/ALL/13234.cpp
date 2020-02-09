#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char a[6], b[6], c[6];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf(" %s %s %s", a, b, c);
	bool aa, cc;
	if (a[0] == 't') aa = true;
	else aa = false;

	if (c[0] == 't') cc = true;
	else cc = false;

	if (b[0] == 'O') printf("%s\n", aa | cc ? "true" : "false");
	else printf("%s\n", aa&cc ? "true" : "false");
}