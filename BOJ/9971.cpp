#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char arr[303];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf(" %s", arr)) {
		if (!strcmp(arr, "ENDOFINPUT")) break;
		if (!strcmp(arr, "START")) continue;
		if (!strcmp(arr, "END")) {
			puts("");
			continue;
		}
		int s = strlen(arr);
		for (int i = 0; i < s; i++) {
			if ('A' > arr[i] || arr[i] > 'Z') printf("%c", arr[i]);
			else if (arr[i] <= 'E') {
				int x = (arr[i] + 'V' - 'A');
				printf("%c", x);
			}
			else {
				int x = (arr[i] + 'V'-'A')%'Z'+'A'-1;
				printf("%c", x);
			}
		}
		printf(" ");
	}
}