#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int main() {
	int n;
	scanf("%d", &n);
	getc(stdin);
	while (n--) {
		int cnt[26] = { 0 };
		char c;
		while ((c = getc(stdin)) != '\n') {
			if (isalpha(c)) {
				++cnt[tolower(c) - 'a'];
			}
		}
		bool check = true;
		for (int i = 0; i < 13; ++i) {
			if (cnt[i] != cnt[26 - i - 1]) {
				check = false;
				break;
			}
		}
		printf("%s\n", check ? "Yes" : "No");
	}
}