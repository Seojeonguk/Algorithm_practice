#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, sum, ans;
bool chk[4000001];
vector<int> v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 2; i < 4000001; i++)
		if (!chk[i]) {
			v.push_back(i);
			for (int j = i * 2; j < 4000001; j += i)
				chk[j] = true;
		}
	int size = v.size();

	scanf("%d", &n);

	int l = 0, r = 0;

	while (l <= r) {
		if (sum > n || r == size - 1) sum -= v[l++];
		else if (sum <= n) sum += v[r++];

		if (sum == n) ans++;
	}
	printf("%d\n", ans);
}