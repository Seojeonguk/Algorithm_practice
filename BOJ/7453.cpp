#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
vector<int> AB, CD;
int n, arr[4001][4];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < 4; j++)
			scanf("%d", &arr[i][j]);

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
		{
			AB.push_back(arr[i][0] + arr[j][1]);
			CD.push_back(arr[i][2] + arr[j][3]);
		}

	sort(AB.begin(), AB.end());
	sort(CD.begin(), CD.end());

	long long int ret = 0;

	for (int i = 0; i < AB.size(); i++) {
		auto cnt = equal_range(CD.begin(), CD.end(), -AB[i]);
		ret += cnt.second - cnt.first;
	}
	printf("%lld\n", ret);
}