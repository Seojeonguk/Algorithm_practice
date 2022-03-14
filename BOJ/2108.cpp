#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, sum, good_value, mode_value;
vector<int> mode;
int arr[500001];
int chk[8003];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
		chk[arr[i] + 4000]++;
		mode_value = max(mode_value, chk[arr[i] + 4000]);
		sum += arr[i];
	}

	sort(arr, arr + n);
	double avg = round((double)sum / (double)n);
	printf("%.0lf\n", avg==-0.0 ? 0.0:avg);
	printf("%d\n", arr[n / 2]);

	for (int i = 0; i < 8003; i++)
		if (mode_value == chk[i])
			mode.push_back(i - 4000);

	printf("%d\n", mode.size() == 1 ? mode[0] : mode[1]);
	printf("%d\n", arr[n - 1] - arr[0]);
}