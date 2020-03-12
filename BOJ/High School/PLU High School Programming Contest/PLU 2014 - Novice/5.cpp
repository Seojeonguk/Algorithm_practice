#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char arr[10003];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int tc;
	scanf("%d", &tc);
	cin.getline(arr, 1000);
	while (tc--) {
		cin.getline(arr, 1000);
		int s = strlen(arr);

		bool ans = true;
		for (int i = 0; i < s / 2; i++) {
			if (isalpha(arr[i])) arr[i] = tolower(arr[i]);
			if (isalpha(arr[s - 1 - i])) arr[s - 1 - i] = tolower(arr[s - 1 - i]);
			if (arr[i] != arr[s - 1 - i]) {
				ans = false;
				break;
			}
		}
		if (ans) puts("Yes");
		else puts("No");
	}
}