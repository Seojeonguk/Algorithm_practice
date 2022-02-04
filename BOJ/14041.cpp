#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int h, m;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d:%d", &h, &m);
	int hm = h * 60 + m;
	for (int i = 0; i < 120; i++) {
		if ((420 <= hm && hm < 600) || (900 <= hm && hm < 1140)) hm += 2;
		else hm++;
	}

	m = (hm % 60);
	h = (hm / 60) % 24;

	printf("%02d:%02d\n", h, m);
}