#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int w, h, n,nowx,nowy,x,y,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &w, &h, &n);

	for (int i = 0; i < n; i++) {
		scanf("%d %d", &x, &y);
		if (!i) nowx = x, nowy = y;
		
		if (x - nowx >= 1 && y - nowy >= 1) ans += max(x - nowx, y - nowy);
		else if (nowx - x >= 1 && nowy - y >= 1) ans += max(nowx - x, nowy - y);
		else ans += abs(nowx - x) + abs(nowy - y);
		nowx = x, nowy = y;
	}
	printf("%d\n", ans);
}