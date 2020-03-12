#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, cnt,ch;
queue<string> q;
string name;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		queue<string> q, ans;
		cnt = 0;

		scanf(" %d ", &n);

		for (int i = 0; i < n; i++) {
			cin >> name;
			scanf(" %d", &ch);
			if (ch == 15) {
				if (!q.empty()) q.pop();
				else cnt++;
			}
			else {
				if (cnt) cnt--;
				else {
					q.push(name);
					if (q.size() > ans.size())
						ans = q;
				}
			}
		}
		if (ans.size()) {
			while (!ans.empty()) {
				cout << ans.front() << " ";
				ans.pop();
			}
			puts("");
		}
		else puts("Line B stayed empty.");
	}
}