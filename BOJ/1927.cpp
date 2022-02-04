#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long long a, b;


int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int n;
	priority_queue<int> q;
	scanf("%d", &n);
	while (n--) {
		int x;
		scanf("%d", &x);

		if (x) q.push(-x);
		else {
			if (q.size()) {
				printf("%d\n", -q.top());
				q.pop();
			}
			else puts("0");
		}

	}
}