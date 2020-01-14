#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int c, d;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &c, &d);
		if (!c) break;
		priority_queue<int> q;
		q.push(-(c * 30 + d * 40));
		q.push(-(c * 35 + d * 30));
		q.push(-(c * 40 + d * 20));
		printf("%d\n", -q.top());
	}
}