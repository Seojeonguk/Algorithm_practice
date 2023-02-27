#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, m, k;
pair<int, int> mold;
bool isChk[2][2];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &m, &k);
	while (k--) {
		scanf("%d %d", &mold.first, &mold.second);
		isChk[mold.first % 2][mold.second % 2] = true;
	}

	bool isClean = true;
	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			if (!isChk[i][j])
				isClean = false;

	puts(isClean ? "YES" : "NO");
}
