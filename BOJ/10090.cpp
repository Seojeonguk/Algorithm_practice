#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;
#define MAXN 1000000

int t, n;
ll ans;
int arr[MAXN], tmp[MAXN];

void mergeSort(int start, int end) {
	if (start >= end) return;
	int mid = (start + end) / 2;
	mergeSort(start, mid);
	mergeSort(mid + 1, end);

	int left = start, right = mid + 1;
	int idx = start;
	while (left <= mid || right <= end) {
		if (right > end || (left <= mid && arr[left] < arr[right])) {
			tmp[idx++] = arr[left++];
		}
		else {
			ans += mid - left + 1;
			tmp[idx++] = arr[right++];
		}
	}

	for (int i = start; i <= end; i++)
		arr[i] = tmp[i];
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	ans = 0;
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		scanf("%d", &arr[i]);

	mergeSort(0, n - 1);

	printf("%lld\n", ans);
}