#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,ans;
pair<int, int> v[10002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		scanf("%d %d", &v[i].first, &v[i].second);

	sort(v, v + n);

	
	int idx_left = v[0].first;
	int high_left = v[0].second;

	int idx_right = v[n - 1].first+1;
	int high_right = v[n - 1].second;
	for (int i = 1; i < n; i++) {
		if (high_left < v[i].second) {
			ans += high_left * (v[i].first - idx_left);
			idx_left = v[i].first;
			high_left = v[i].second;
		}

		if (high_right < v[n-i-1].second) {
			ans += high_right * (idx_right - v[n-i-1].first - 1);
			idx_right = v[n-i-1].first+1;
			high_right = v[n-i-1].second;
		}

	}

	ans += high_right * (idx_right - idx_left);

	printf("%d\n", ans);
}