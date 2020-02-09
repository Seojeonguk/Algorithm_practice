#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char a[2503], b[53];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	gets_s(a);
	gets_s(b);

	int a_size = strlen(a);
	int b_size = strlen(b);

	int cnt = 0;
	for (int i = 0; i <= a_size- b_size;) {
		bool chk = true;
		for (int j = i; j < i+b_size; j++) {
			if (a[j] != b[j-i]) {
				chk = false;
				break;
			}
		}
		if (chk) {
			cnt++;
			i += b_size;
		}
		else i++;
	}

	printf("%d\n", cnt);
}