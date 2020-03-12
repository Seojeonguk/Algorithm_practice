#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int m,arr[6][6];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int n;
	scanf("%d", &n);
	while (n--) {
		scanf("%d", &m);
		for (int i = 0; i < m; i++)
			for (int j = 0; j < m; j++)
				scanf("%d", &arr[i][j]);

		int sum1 = 0, sum2 = 0;
		vector<int> v;

		for (int i = 0; i < m; i++) {
			sum1 = sum2 = 0;
			for (int j = 0; j < m; j++) {
				sum1 += arr[i][j];
				sum2 += arr[j][i];
			}
			v.push_back(sum1);
			v.push_back(sum2);
		}

		sum1 = sum2 = 0;
		for (int i = 0; i < m; i++) {
			sum1 += arr[i][i];
			sum2 += arr[i][m-1-i];
		}
		v.push_back(sum1);
		v.push_back(sum2);

		sort(v.begin(), v.end());

		if (v[0] != v[v.size() - 1]) puts("Not a magic square");
		else printf("Magic square of size %d\n", m);
	}
}