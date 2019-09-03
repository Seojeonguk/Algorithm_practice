#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool num[102];
int x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &x);
		if (x == -1) break;
		memset(num, 0, sizeof num);
		vector<int> v;
		v.push_back(x);
		num[x] = true;
		while (scanf("%d", &x)) {
			if (x == 0) break;
			num[x] = true;
			v.push_back(x);
		}
		int ans = 0;
		for (int i = 0; i < v.size(); i++)
			if (num[v[i] * 2])
				ans++;

		printf("%d\n", ans);
	}
}