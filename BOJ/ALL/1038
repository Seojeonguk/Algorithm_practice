#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long long int n;
set<long long int> s;

long long int solve() {
	long long int cnt = 0;
	priority_queue<long long int, vector<long long int>, greater<long long int> > q;
	for (long long int i = 0; i < 10; i++) {
		s.insert(i);
		q.push(i);
	}

	while (!q.empty()) {
		long long int outdata = q.top();
		q.pop();


		if (cnt == n) return outdata;
		cnt++;

		long long int next = outdata % 10;
		for (int i = 0; i < next; i++) {
			long long int ni = outdata * 10 + i;
			if (s.find(ni) != s.end()) continue;
			s.insert(ni);
			q.push(ni);
		}
	}

	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld", &n);

	printf("%lld\n", n <= 10 ? n : solve());
}