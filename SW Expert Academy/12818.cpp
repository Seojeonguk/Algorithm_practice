#include<cstdio>
using namespace std;
typedef long long ll;
#define MAXN 100000

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
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		ans = 0;
		scanf("%d", &n);

		for (int i = 0; i < n; i++)
			scanf("%d", &arr[i]);

		mergeSort(0, n - 1);

		printf("#%d %lld\n", tc, ans);
	}
}