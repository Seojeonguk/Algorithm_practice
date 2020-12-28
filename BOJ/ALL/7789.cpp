#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &a, &x);

	int new_number = x * 1000000 + a;
	bool chk = true;

	for (int i = 2; i < a; i++) {
		if (a % i == 0) {
			chk = false;
			break;
		}
	}

	for (int i = 2; i < new_number; i++) {
		if (new_number % i == 0) {
			chk = false;
			break;
		}
	}
	puts(chk ? "Yes" : "No");
}