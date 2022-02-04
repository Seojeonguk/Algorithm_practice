#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

pair<int, int> p[1000045];
int root, value;

void solve(int idx) {
	if (p[idx].first) solve(p[idx].first);
	if (p[idx].second) solve(p[idx].second);
	printf("%d\n", idx);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &root);
	while (scanf("%d", &value) != EOF) {
		int now = root;
		while (1) {
			if (now > value) {
				if (!p[now].first) {
					p[now].first = value;
					break;
				}
				else now = p[now].first;
			}
			else {
				if (!p[now].second) {
					p[now].second = value;
					break;
				}
				else now = p[now].second;
			}
		}
	}

	solve(root);
}