#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;


int l, w, h, v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d %d %d", &l, &w, &h, &v);

		if (!l && !w && !h && !v) break;

		printf("%d %d %d %d\n", l ? l : v / w / h, w ? w : v / l / h, h ? h : v / l / w, v ? v : l * w * h);
	}
}