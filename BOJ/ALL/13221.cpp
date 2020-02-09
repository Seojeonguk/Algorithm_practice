#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
pair<int, int> now, ans;
int ans_length=99999999,n,x,y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &now.first, &now.second);
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);
		int length = abs(now.first - x) + abs(now.second - y);
		if (ans_length > length) {
			ans_length = length;
			ans.first = x;
			ans.second = y;
		}
	}

	printf("%d %d\n", ans.first, ans.second);
}