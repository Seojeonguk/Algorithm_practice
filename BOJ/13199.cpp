#include <iostream>

using namespace std;

long long T, P, M, F, C;

int main(void) {
	ios_base::sync_with_stdio(false), cin.tie(nullptr);
	cin >> T;
	while(T--) {
		cin >> P >> M >> F >> C;
		cout << (M/P*C > F ? (M/P*C - F)/(F - C) - M/P*C/F + 1: 0)<< '\n';
	}
	
	return 0;
}