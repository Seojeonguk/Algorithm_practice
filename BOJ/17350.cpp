#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
char arr[103];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf(" %s", arr);
		if (strcmp(arr, "anj") == 0) {
			puts("构具;");
			return 0;
		}
	}
	puts("构具?");
}