#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t;
char ch[22];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf(" %s", ch);

		int length = strlen(ch);

		bool chk = true;

		for (int i = 0; i < length / 2; i++) {
			if (ch[i] != ch[length - i - 1]) {
				chk = false;
				break;
			}
		}

		printf("#%d %d\n", tc, chk);
	}
}