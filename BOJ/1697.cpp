#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, k;
bool visit[100002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);
	queue<pair<int, int> > q;
	q.push({ 0,n });
	visit[n] = true;
	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();

		if (outdata.second == k) {
			printf("%d\n", outdata.first);
			return 0;
		}
		if (outdata.second - 1 >= 0 && !visit[outdata.second - 1]) {
			q.push({ outdata.first + 1,outdata.second - 1 });
			visit[outdata.second - 1] = true;
		}
		if (outdata.second + 1 <= 100000 && !visit[outdata.second + 1]) {
			q.push({ outdata.first + 1,outdata.second + 1 });
			visit[outdata.second + 1] = true;
		}
		if (outdata.second * 2 <= 100000 && !visit[outdata.second * 2]) {
			q.push({ outdata.first + 1,outdata.second * 2 });
			visit[outdata.second * 2] = true;
		}
	}
}