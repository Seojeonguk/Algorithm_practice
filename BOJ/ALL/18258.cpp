#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, x;
char arr[9];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	deque<int> q;
	for (int i = 0; i < n; i++) {
		scanf(" %s", arr);
		if (arr[0] == 'p') {
			if (arr[1] == 'u') {
				scanf("%d", &x);
				q.push_back(x);
			}
			else {
				if (q.empty()) printf("-1\n");
				else {
					printf("%d\n", q.front());
					q.pop_front();
				}
			}
		}
		else if (arr[0] == 'e') printf("%d\n", q.empty());
		else if (arr[0] == 'f') printf("%d\n", q.empty() ? -1 : q.front());
		else if (arr[0] == 'b') printf("%d\n", q.empty() ? -1 : q.back());
		else printf("%d\n", q.size());
	}
}