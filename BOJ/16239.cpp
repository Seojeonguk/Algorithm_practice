#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int k,n,x;
vector<int> v;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &k, &n);

	for (int i = 1; i < n; i++) {
		printf("%d\n", i);
		k -= i;
	}
	printf("%d\n", k);
}