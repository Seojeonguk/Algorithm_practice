#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m,x,y,cost;
vector<pair<int, int> > v[1002];
int d[1002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	memset(d, -1, sizeof d);
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &x, &y, &cost);
		v[x].push_back({ y,cost });
		v[y].push_back({ x,cost });
	}
	priority_queue<pair<int, pair<int,int> > > q;
	q.push({ 0,{1,0} });
	vector<pair<int, int> > vv;

	while (!q.empty()) {
		auto outdata = q.top();
		outdata.first = -outdata.first;
		q.pop();
		if (d[outdata.second.first] != -1) continue;
		d[outdata.second.first] = outdata.first;
		if (outdata.second.second != 0) vv.push_back({ outdata.second.first , outdata.second.second });

		int size = v[outdata.second.first].size();
		for (int i = 0; i < size; i++) {
			if (d[v[outdata.second.first][i].first] != -1) continue;
			q.push({ -(outdata.first + v[outdata.second.first][i].second),{v[outdata.second.first][i].first,outdata.second.first} });

		}
	}

	int size = vv.size();
	printf("%d\n", size);
	for (int i = 0; i < size; i++)
		printf("%d %d\n", vv[i].first,vv[i].second);
}
