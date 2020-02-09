#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,a,b,c,ans=100000000;
vector<int> v;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <=sqrt(n); i++) {
		if (n%i == 0) {
			v.push_back(i);
			if (i !=sqrt(n)) v.push_back(n/i);
		}
	}
	sort(v.begin(), v.end());

	int s = v.size();

	for (int i = 0; i < s; i++) {
		for (int j = 0; j < s; j++) {
			if (v[i] * v[j] > n) break;
			for (int k = 0; k < s; k++) {
				int m = v[i] * v[j] * 2 + v[i] * v[k] * 2 + v[j] * v[k] * 2;\
				if (v[i] * v[j] * v[k] > n) break;
				else if (v[i] * v[j] * v[k] == n) {
					if (m < ans) {
						ans = m;
						a = v[i], b = v[j], c = v[k];
					}
				}
			}
		}
	}
	printf("%d %d %d\n", a, b, c);
}