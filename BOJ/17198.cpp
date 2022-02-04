#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int X[] = { 1,0,-1,0 }, Y[] = { 0,1,0,-1 };
char m[13][13];
bool visit[13][13];
pair<int, int> s, d;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 10; i++) {
		scanf("%s", m[i]);
		for (int j = 0; j < 10; j++)
			if (m[i][j] == 'B')s.first = i, s.second = j;
			else if (m[i][j] == 'L') d.first = i, d.second = j;
	}
	queue < pair<int, pair<int, int> >  >q;
	q.push({ 0,s });
	visit[s.first][s.second] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second.first == d.first && outdata.second.second == d.second) {
			printf("%d\n", outdata.first-1);
			break;
		}

		for (int i = 0; i < 4; i++) {
			auto indata = outdata.second;
			indata.first += X[i], indata.second += Y[i];
			if (indata.first < 0 || indata.second < 0 || indata.first >= 10 || indata.second >= 10 || visit[indata.first][indata.second] || m[indata.first][indata.second]=='R') continue;
			visit[indata.first][indata.second] = true;
			q.push({ outdata.first + 1,indata });
		}
	}
}