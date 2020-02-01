#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char chk[] = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
char a[10000000];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (gets(a)) {
		for (int i = 0; a[i]; i++) {
			if (a[i] == ' ') {
				printf(" ");
				continue;
			}

			for (int j = 0; chk[j]; j++)
				if (a[i] == chk[j]) {
					printf("%c", chk[j - 1]);
					break;
				}
		}
		printf("\n");
	}
}