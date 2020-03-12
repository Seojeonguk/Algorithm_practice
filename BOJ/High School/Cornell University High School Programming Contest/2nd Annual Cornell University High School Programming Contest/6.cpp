#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n,x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		bool chk = true;
		scanf(" %d ", &n);
		vector<int> v1(1000001);
		vector<int> v2(1000001);
		vector<int> ans(1000001);

		for (int i = 0; i < n; i++) {
			scanf("%d", &x);
			v1[x]++;
		}

		for (int i = 0; i < 1000001; i++) ans[v1[i]]++;

		for (int i = 0; i < n; i++) {
			scanf("%d", &x);
			v2[x]++;
		}

		for (int i = 0; i < 1000001; i++) ans[v2[i]]--;
		for(int i=0;i<1000001;i++) 
			if (ans[i]) {
				chk = false;
				break;
			}

		if (chk) puts("what a lovely party");
		else puts("you've messed up, Cornell");
	}
}