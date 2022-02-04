#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m,he[1001],jo[1001];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) scanf("%d", &he[i]);
	for (int i = 0; i < m; i++) scanf("%d", &jo[i]);
	sort(he, he + n);
	sort(jo, jo + m);
	printf("%d\n", he[n - 1] + jo[m - 1]);
}