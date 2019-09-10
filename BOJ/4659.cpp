#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char arr[22];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf(" %s", arr) != EOF) {
		if (!strcmp(arr, "end")) break;
		int s = strlen(arr);
		bool chk = true;
		bool mo = false;
		bool ja_mo = true; // 0 자음, 1 모음
		int cnt = 0;
		for (int i = 0; i < s; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'o' || arr[i] == 'u' || arr[i] == 'i') {
				mo = true;
				if (ja_mo) cnt++;
				else {
					ja_mo = true;
					cnt = 1;
				}
			}
			else {
				if (!ja_mo) cnt++;
				else {
					ja_mo = false;
					cnt = 1;
				}
			}
			if (!i) continue;
			if (cnt >= 3) chk = false;
			if (arr[i] != 'e' && arr[i] != 'o') {
				if (arr[i] == arr[i - 1]) chk = false;
			}
		}

		if (!mo) chk = false;

		if (chk) printf("<%s> is acceptable.\n",arr);
		else printf("<%s> is not acceptable.\n",arr);
	}
}