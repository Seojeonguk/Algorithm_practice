#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
pair<int, int> p[3];
int arr[3];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 3; i++) scanf("%d %d", &p[i].first, &p[i].second);

	if (p[0].first == p[1].first && p[1].first == p[2].first) {
		puts("X");
		return 0;
	}
	else if (p[0].second == p[1].second && p[1].second == p[2].second) {
		puts("X");
		return 0;
	}

	double a = 1.*abs(p[1].second - p[0].second) / abs(p[1].first - p[0].first);
	double b = 1.*abs(p[2].second - p[1].second) / abs(p[2].first - p[1].first);
	if (a == b) {
		puts("X");
		return 0;
	}

	arr[0] = pow(abs(p[0].first - p[1].first), 2) + pow(abs(p[0].second - p[1].second), 2);
	arr[1] = pow(abs(p[1].first - p[2].first), 2) + pow(abs(p[1].second - p[2].second), 2);
	arr[2] = pow(abs(p[2].first - p[0].first), 2) + pow(abs(p[2].second - p[0].second), 2);
	
	sort(arr, arr + 3);
	if (arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == arr[2]) puts("JungTriangle");
	else if (arr[0] + arr[1] == arr[2] || arr[0] + arr[2] == arr[1] || arr[2] + arr[1] == arr[0]) {
		if (arr[0] == arr[1] || arr[1] == arr[2]) puts("Jikkak2Triangle");
		else puts("JikkakTriangle");
	}
	else if (arr[0] + arr[1] < arr[2] || arr[0] + arr[2] < arr[1] || arr[2] + arr[1] < arr[0]) {
		if (arr[0] == arr[1] || arr[1] == arr[2]) puts("Dunkak2Triangle");
		else puts("DunkakTriangle");
	}
	else {
		if (arr[0] == arr[1] || arr[1] == arr[2]) puts("Yeahkak2Triangle");
		else puts("YeahkakTriangle");
	}
}