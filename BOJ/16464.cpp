#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

long lim = 1000000000;

vector<long> v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (long i = 2; i < lim; i<<=1)
		v.push_back(i);
	int size = v.size();
	int test;
	scanf("%d", &test);

	while (test--) {
		long dealer;
		scanf("%ld", &dealer);
		bool chk = false;
		for (int i = 0; i < size; i++) {
			if (dealer == v[i]) {
				chk = true;
				break;
			}
		}
		if (chk) puts("GoHanGang");
		else puts("Gazua");
	}
}