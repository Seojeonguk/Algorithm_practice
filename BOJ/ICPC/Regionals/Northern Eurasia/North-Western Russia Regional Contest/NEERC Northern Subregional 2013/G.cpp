#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int W, H, w, h;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d %d", &W, &H, &w, &h);

	printf("%d\n", ((H / h + 1) / 2) * ((W / w + 1) / 2));
}