#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b, c, d, e, f;
int t;
char start_now;
struct dd {
	int now, tmp, cnt;
	bool sta;
};

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		int ans = 6;
		scanf("%d.%d %d.%d %c %d.%d", &a,&b,&c,&d,&start_now,&e,&f);
		a = a * 1000 + b;
		c = c * 1000 + d;
		e = e * 1000 + f;
		if (start_now == 'B') swap(a, c);
		queue<dd> q;
		q.push({ a,c,0,0 });
		q.push({ a,c,0,1 });
		while (!q.empty()) {
			auto outdata = q.front();
			q.pop();

			if (outdata.now == e) {
				ans = min(ans, outdata.cnt);
				break;
			}
			if (outdata.cnt == 5) continue;

			if (outdata.sta) {
				if (outdata.now + 20 > 146000) q.push({ 144000,outdata.tmp,outdata.cnt + 1,1 });
				else q.push({ outdata.now + 20,outdata.tmp,outdata.cnt + 1,1 });
			}

			if (!outdata.sta) {
				if (outdata.now - 20 < 144000) q.push({ 146000,outdata.tmp,outdata.cnt + 1,0 });
				else q.push({ outdata.now - 20 , outdata.tmp, outdata.cnt + 1,0 });
			}

			q.push({ outdata.tmp,outdata.now,outdata.cnt + 1,outdata.sta });
		}

		printf("%d\n", ans);
	}
}