#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, MOD = -2;
stack<int> s;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	if (n == 0) {
		puts("0");
		return 0;
	}

	while (n != 0) {
		s.push(abs(n % MOD));
		n = ceil(1.*n/MOD);
	}


	while (!s.empty()) {
		printf("%d", s.top());
		s.pop();
	}
}