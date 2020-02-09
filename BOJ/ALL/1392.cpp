#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, q,t,idx;
int ok[10004];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &q);

	for (int i = 0; i < n; i++) {
		scanf("%d", &t);
		for (int j = idx; j < idx + t; j++) ok[j] = i + 1;
		idx += t;
	}
	for (int i = 0; i < q; i++) {
		scanf("%d", &t);
		printf("%d\n", ok[t]);
	}
}