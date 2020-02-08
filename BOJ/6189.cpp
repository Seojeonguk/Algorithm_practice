#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int r,c,X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
char m[103][103];
bool visit[103][103];
pair<int, int> s, d;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &r, &c);
	for (int i = 0; i < r; i++) {
		scanf("%s", m[i]);
		for (int j = 0; j < c; j++)
			if (m[i][j] == 'B')s.first = i, s.second = j;
			else if (m[i][j] == 'C') d.first = i, d.second = j;
	}
	queue < pair<int, pair<int, int> >  >q;
	q.push({ 0,s });
	visit[s.first][s.second] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second.first == d.first && outdata.second.second == d.second) {
			printf("%d\n", outdata.first);
			break;
		}

		for (int i = 0; i < 4; i++) {
			auto indata = outdata.second;
			indata.first += X[i], indata.second += Y[i];
			if (indata.first < 0 || indata.second < 0 || indata.first >= r || indata.second >= c || visit[indata.first][indata.second] || m[indata.first][indata.second]=='*') continue;
			visit[indata.first][indata.second] = true;
			q.push({ outdata.first + 1,indata });
		}
	}
}