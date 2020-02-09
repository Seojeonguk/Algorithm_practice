#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long long a, b;
queue<pair<long long, int> > q;
set<long long> s;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &a, &b);
	q.push({ a,1 });

	while (!q.empty()) {
		pair<long long,int> outdata = q.front();
		q.pop();

		if (outdata.first > (long)1e+9 || outdata.first > b) continue;
		if (outdata.first == b) {
			printf("%d\n", outdata.second);
			return 0;
		}
		long long indata = outdata.first * 2;
		if (s.find(indata) == s.end()) {
			s.insert(indata);
			q.push({ indata,outdata.second + 1 });
		}
		indata = outdata.first * 10 + 1;
		if (s.find(indata) == s.end()) {
			s.insert(indata);
			q.push({ indata,outdata.second + 1 });
		}
	}
	puts("-1");
}