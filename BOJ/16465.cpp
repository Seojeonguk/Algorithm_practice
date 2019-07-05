#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, l;
int book_width, total_width;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &l);

	for (int i = 0; i < n; i++) {
		scanf("%d", &book_width);
		total_width += book_width;
	}

	if (total_width < m) {
		if (m < l) puts("-1");
		else {
			if (total_width >= l) puts("1");
			else puts("-1");
		}
	}
	else if (total_width == m) puts("0");
	else puts("-1");
	
}