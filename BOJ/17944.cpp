#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,t;
vector<int> v;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &t);
	n = 2 * (2*n - 1);
	t--;
	int tmp = 0;
	for (int i = 1; i <= n; i++) {
		if (i > n / 2 + 1) tmp -= 1;
		else tmp += 1;
		v.push_back(tmp);
	}

	printf("%d\n", v[t%n]);
}