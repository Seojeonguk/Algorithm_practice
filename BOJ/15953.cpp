#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, a, b;
vector<pair<int, int> > A = { {0,0}, {1,500},{3,300},{6,200},{10,50},{15,30},{21,10},{101,0} };
vector<pair<int, int> > B = { {0,0}, {1,512},{3,256},{7,128},{15,64},{31,32},{65,0} };
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (scanf("%d", &t); t != 0; t--) {
		scanf("%d %d", &a, &b);
		int ans = 0;
		for (int i = 6; i >= 0; i--) {
			if (a > A[i].first) {
				ans += A[i+1].second;
				break;
			}
		}
		for (int i = 5; i >= 0; i--) {
			if (b > B[i].first) {
				ans += B[i+1].second;
				break;
			}
		}
		printf("%d\n", ans * 10000);
	}
}