#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m;
char ori[104], post[1005];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %s", &n, &m,ori);

	while (m--) {
		int ori_idx = 0,post_idx=0;
		scanf(" %s", post);
		int size = strlen(post);

		while (1) {
			if (ori_idx == n || post_idx == size) break;
			if (ori[ori_idx] == post[post_idx]) ori_idx++;
			post_idx++;
		}
		if (ori_idx == n) puts("true");
		else puts("false");
	}
}