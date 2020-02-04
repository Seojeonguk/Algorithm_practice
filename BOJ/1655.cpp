#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, x;
priority_queue<int> l, r;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		if (l.size() == r.size()) l.push(x);
		else r.push(-x);

		if (!l.empty() && !r.empty() && -r.top() < l.top()) {
			r.push(-l.top());
			l.pop();
			l.push(-r.top());
			r.pop();
		}
		printf("%d\n", l.top());
	}
}