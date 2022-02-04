#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long int ll;
ll factorial[21],M,ans;
int N, K,a[21];
bool check[22];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	factorial[0] = factorial[1] = 1;
	for (int i = 2; i < 21; i++)
		factorial[i] = factorial[i - 1] * i;

	scanf("%d %d", &N, &K);

	if (K == 1) {
		scanf("%lld", &M);

		for (int i = 0; i < N; i++) {
			for (int j = 1; j <= N; j++) {
				if (check[j] == true) continue;
				if (M <= factorial[N - i - 1]){
					check[j] = true;
					printf("%d ", j);
					break;
				}
				M -= factorial[N - i - 1];
			}
		}
	}
	else {
		for (int i = 0; i < N; i++) scanf("%d", &a[i]);
		ans = 1;

		for (int i = 0; i < N; i++){
			for (int j = 1; j <= N; j++) {
				if (check[j] == true)continue;
				if (a[i] == j) break;
				ans += factorial[N - i - 1];
			}
			check[a[i]] = true;
		}
		printf("%lld", ans);
	}
}