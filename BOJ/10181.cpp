#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &n);
		if (n<0) break;
		vector<int> v;
		int sum = 1;
		for (int i = 2; i < n; i++) {
			if (n%i == 0) {
				sum += i;
				v.push_back(i);
			}
		}

		if (sum == n) {
			printf("%d = 1", n);
			for (int i : v) printf(" + %d", i);
			puts("");
		}
		else printf("%d is NOT perfect.\n", n);
	}
}