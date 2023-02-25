#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int ans, x, st;
set<int> s;
queue<pair<int, int>> q;

int conversion(int v, int type) {
	int square[8] = { 0, };
	for (int i = 0; i < 8; i++, v /= 10)
		square[i] = v % 10;

	if (type == 0) {
		for (int i = 0; i < 4; i++)
			swap(square[i], square[7 - i]);
	}
	else if (type == 1) {
		for (int i = 1; i <= 3; i++) {
			swap(square[0], square[i]);
			swap(square[7], square[7 - i]);
		}
	}
	else if (type == 2) {
		swap(square[1], square[2]);
		swap(square[1], square[5]);
		swap(square[1], square[6]);
	}
	else if (type == 3) {
		swap(square[3], square[7]);
	}

	int ret = 0;
	for (int i = 7; i >= 0; i--)
		ret = ret * 10 + square[i];

	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int i = 0; i < 8; i++) {
		scanf("%d", &x);
		ans = ans * 10 + x;
	}

	for (int i = 1; i <= 8; i++)
		st = st * 10 + i;


	s.insert(st);
	q.push({ 0,st });

	while (!q.empty()) {
		int magic_square = q.front().second;
		int cnt = q.front().first;
		q.pop();

		if (magic_square == ans) {
			printf("%d\n", cnt);
			break;
		}

		for (int i = 0; i < 4; i++) {
			int conversion_number = conversion(magic_square, i);
			if (s.find(conversion_number) == s.end()) {
				s.insert(conversion_number);
				q.push({ cnt + 1,conversion_number });
			}
		}
	}
}
