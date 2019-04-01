#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, arr[10], ans = -987654321;
struct d {
	int now, sum, chk;
};
queue<d> q;

int main() {
#ifdef _CONSOLE
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	q.push({ 0,0,0 });

	while (!q.empty()) {
		auto outdata = q.front();
		q.pop();
		//printf("%d %d %d\n", outdata.now, outdata.sum, outdata.chk);
		if (outdata.chk == (1 << n) - 1) {
			ans = max(ans, outdata.sum);
			continue;
		}

		for (int i = 0; i < n; i++) {
			if (!(outdata.chk & (1 << i))) {
				if (!outdata.chk) q.push({ arr[i],0,1 << i });
				else q.push({ arr[i],outdata.sum + abs(outdata.now - arr[i]),outdata.chk | (1 << i) });
			}
		}
	}
	printf("%d\n", ans);
}