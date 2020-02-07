#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int x, y;
#define MAX 1000000000
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%lld %lld", &x, &y);

	int Z = (y * 100) / x;
	if (Z >= 99) {
		cout << -1 << "\n";
		return 0;
	}

	int low = 0, high = MAX;
	int result = -1;
	while (low <= high) {
		int mid = (low + high) / 2;

		long long int tempZ = (100 * (y + mid)) / (x + mid);

		if (Z >= tempZ) {
			result = mid + 1;
			low = mid + 1;
		}
		else high = mid - 1;
	}

	printf("%d\n", result);
}