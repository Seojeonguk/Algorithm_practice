#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int N, m, M, T, R, now, ans,now_p;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d %d", &N, &m, &M, &T, &R);
	now = m;
	while (N) {
		if (now == now_p) {
			ans = -1;
			break;
		}
		now_p = now;
		if (now + T <= M) {
			now += T;
			N--;
		}
		else {
			if (now - R < m) now = m;
			else now -= R;
		}
		ans++;
	}
	printf("%d\n", ans);
}