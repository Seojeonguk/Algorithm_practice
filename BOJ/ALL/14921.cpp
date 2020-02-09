#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
int ans = 2e9;
int a, b;
int r, l;


int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	vector<int> v(n);

	for (int i = 0; i < n; i++) scanf("%d", &v[i]);
	sort(v.begin(), v.end());
	r = 0, l = n - 1;
	while (r < l) {
		if (abs(v[r] + v[l]) < abs(ans)) {
			a = v[r], b = v[l];
			ans = v[r] + v[l];
		}
		if (v[l] + v[r] < 0)
			r++;
		else
			l--;
	}

	printf("%d\n", ans);
}