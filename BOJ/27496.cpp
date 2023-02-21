#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, l;
int alcohol[1000000];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &l);

	int current_alcohol = 0;
	int ans = 0;
	for (int i = 0; i < n; i++) {
		scanf("%d", &alcohol[i]);

		current_alcohol += alcohol[i];
		if (i >= l)
			current_alcohol -= alcohol[i - l];
		if (129 <= current_alcohol && current_alcohol <= 138)
			ans++;
	}
	printf("%d\n", ans);
}
