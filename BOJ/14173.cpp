#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x, y;
int xmin=10, xmax, ymin=10, ymax;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 4; i++) {
		scanf("%d %d", &x, &y);
		xmin = min(xmin, x);
		xmax = max(xmax, x);
		ymin = min(ymin, y);
		ymax = max(ymax, y);
	}

	int length = max(xmax - xmin, ymax - ymin);
	printf("%d\n", length*length);
}