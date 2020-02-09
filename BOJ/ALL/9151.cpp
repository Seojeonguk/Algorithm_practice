#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
vector<int> v1, v2;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i <= 53; i++) v1.push_back(i*i*i);
	for (int i = 0; i <= 95; i++) v2.push_back(i*(i + 1)*(i + 2) / 6);
	while (1) {
		scanf("%d", &n);
		if (!n) break;
		int ans = 0;
		for (int i = 0; i <= 53; i++) {
			for (int j = 0; j <= 95; j++)
				if (v1[i] + v2[j] <= n) ans = max(ans, v1[i] + v2[j]);
				else break;
		}
		printf("%d\n", ans);
	}
}