#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, a[21][21];
bool v[21];
vector<int> res;

void solve(int cho,int cnt) {
	if (cnt == n / 2) {
		int cho_l = 0, cho_r=0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (v[i] == v[j]) {
					if (v[i]) cho_l += a[i][j] + a[j][i];
					else cho_r += a[i][j] + a[j][i];
				}
			}
		}
		res.push_back(abs(cho_l - cho_r));

		return;
	}

	for (int i = cho; i < n; i++) {
		if (!v[i]) {
			v[i] = true;
			solve(i+1,cnt+1);
			v[i] = false;
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			scanf("%d", &a[i][j]);

	solve(0,0);

	sort(res.begin(), res.end());

	printf("%d\n", res[0]/2);
}