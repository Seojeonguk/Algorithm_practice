#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, p,cnt;
stack<int> s[7];
int x, y;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &p);
	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);
		if (s[x].empty()) {
			s[x].push(y);
			cnt++;
		}
		else {
			while (!s[x].empty() && s[x].top() > y) {
				s[x].pop();
				cnt++;
			}
			if (s[x].empty()) {
				s[x].push(y);
				cnt++;
			}
			else {
				if (s[x].top() != y) {
					s[x].push(y);
					cnt++;
				}
			}
		}
	}
	printf("%d\n", cnt);
}