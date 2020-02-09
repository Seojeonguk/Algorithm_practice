#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
priority_queue<int> q;
int x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 50; i++) {
		scanf("%d", &x);
		q.push(x);
	}
	scanf("%d", &x);
	int idx = 1;
	while (!q.empty()) {
		if (q.top() == x) break;
		else q.pop();
		idx++;
	}
	if (idx <= 5) puts("A+");
	else if (idx <= 15) puts("A0");
	else if (idx <= 30) puts("B+");
	else if (idx <= 35) puts("B0");
	else if (idx <= 45) puts("C+");
	else if (idx <= 48) puts("C0");
	else puts("F");
}