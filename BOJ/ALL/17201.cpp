#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
set<int> s;
int n, k;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	while (k) {
		s.insert(k % 100);
		k /= 100;
	}

	if (s.size() == 1) puts("Yes");
	else puts("No");
}