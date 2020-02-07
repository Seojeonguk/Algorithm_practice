#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n;
bool chk[1000001];
vector<int> v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 2; i < 1000001; i++)
		if (!chk[i]) {
			v.push_back(i);
			for (int j = i * 2; j < 1000001; j += i)
				chk[j] = true;
		}
	int size = v.size();

	while (1) {
		bool f = true;
		scanf("%d", &n);
		if (!n) break;
		for (int i = 0; i < size; i++)
			if (n - v[i] > 0 && !chk[n - v[i]]) {
				printf("%d = %d + %d\n", n, v[i], n - v[i]);
				f = false;
				break;
			}
		if (f) puts("Goldbach's conjecture is wrong.");
	}
}