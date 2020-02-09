#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, X[] = { -3,3,0,1,-1 };
char arr[4];
string des = ".........";

int solve(string start) {
	set<string> s;
	queue<pair<string, int> > q;
	s.insert(start);
	q.push({ start,0 });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.first == des) return outdata.second;
		for (int i = 0; i < 9; i++) {
			string indata = outdata.first;
			for (int j = 0; j < 5; j++) {
				int tmp = i + X[j];
				if (tmp < 0 || tmp>8) continue;
				if (j >= 3 && (tmp / 3 != i / 3)) continue;
				if (indata[tmp] == '.') indata[tmp] = '*';
				else indata[tmp] = '.';
			}
			if (s.find(indata) != s.end()) continue;
			s.insert(indata);
			q.push({ indata,outdata.second + 1 });
		}
	}

	return -1;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int i = 0; i < t; i++) {
		string st="";
		for (int j = 0; j < 3; j++) {
			scanf("%s", arr);
			st += arr;
		}
		printf("%d\n", solve(st));
	}
}