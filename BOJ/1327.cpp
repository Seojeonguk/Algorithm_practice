#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, k,x;
string s,des,tmp,indata;
set<string> se;
int solve() {
	des = s;
	sort(des.begin(), des.end());
	queue<pair<string, int> > q;
	se.insert(s);
	q.push({ s,0 });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.first == des) return outdata.second;

		for (int i = 0; i <= n - k; i++) {
			tmp = outdata.first.substr(i, k);
			reverse(tmp.begin(), tmp.end());
			indata = outdata.first.substr(0, i) + tmp + outdata.first.substr(i + k, n);
			if (se.find(indata) == se.end()) {
				se.insert(indata);
				q.push({ indata,outdata.second + 1 });
			}
		}
	}

	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);
	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		s += x+'0';
	}
	printf("%d\n", solve());
}