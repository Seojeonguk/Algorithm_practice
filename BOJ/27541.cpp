#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n;
char aoi[102];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %s", &n, aoi);

	if (aoi[n - 1] == 'G') {
		aoi[n - 1] = '\0';
	}
	else {
		aoi[n] = 'G';
		aoi[n + 1] = '\0';
	}

	puts(aoi);
}
