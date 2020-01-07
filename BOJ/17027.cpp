#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,arr[3],ans[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < 3; i++) arr[i] = i;

	int a,b, g;
	for (int i = 0; i < n; i++) {
		scanf("%d %d %d", &a, &b, &g);
		swap(arr[a-1], arr[b-1]);
		ans[arr[g-1]]++;
	}
	printf("%d\n", max(ans[0], max(ans[1], ans[2])));
}