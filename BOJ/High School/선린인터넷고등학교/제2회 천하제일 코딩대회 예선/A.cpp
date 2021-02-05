#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int a, b;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &a, &b);

	// 12시간 기준 12시간 이동
	// 12시간 기준 a/b*12 시간 이동
	// a/b-1번 만남
	printf("%d\n", (abs(a - b) * 2) / b);
}