#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
const int LIM = 100000;
int n, t, g,cnt=-1;
queue<pair<int, int> > q;
bool visit[100002];

int high_num(int x) {
	for (int i = 100000; i >= 1; i /= 10)
		if (x / i) return i;
	return 0;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &t, &g);
	q.push({ n,0 });
	visit[n] = true;

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		if (outdata.first == g) {
			cnt = outdata.second;
			break;
		}
		if (outdata.second == t) continue;

		if (outdata.first + 1 < LIM && !visit[outdata.first + 1]) {
			q.push({ outdata.first + 1,outdata.second + 1 });
			visit[outdata.first + 1] = true;
		}

		if (outdata.first * 2 < LIM && !visit[outdata.first * 2 - high_num(outdata.first*2)]) {
			q.push({ outdata.first * 2 - high_num(outdata.first*2),outdata.second+1 });
			visit[outdata.first * 2 - high_num(outdata.first * 2)] = true;
		}
	}

	if (cnt!=-1) printf("%d", cnt);
	else puts("ANG");
}