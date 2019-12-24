#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
pair<int,int> sum;
int prat[3];
string unv[3] = { "Soongsil","Korea","Hanyang" };
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) {
		scanf("%d", &prat[i]);
		sum.first += prat[i];
		if (prat[sum.second] > prat[i])
			sum.second = i;
	}

	if (sum.first >= 100) puts("OK");
	else cout << unv[sum.second];
}