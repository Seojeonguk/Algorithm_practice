#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
string arr[13];
int n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif]
	cin >> n;
	arr[1] = "\n";
	arr[2] = "\n";
	arr[3] = " 1 2\n";
	arr[4] = " 1 3\n";
	arr[5] = " 1 4, 2 3\n";
	arr[6] = " 1 5, 2 4\n";
	arr[7] = " 1 6, 2 5, 3 4\n";
	arr[8] = " 1 7, 2 6, 3 5\n";
	arr[9] = " 1 8, 2 7, 3 6, 4 5\n";
	arr[10] = " 1 9, 2 8, 3 7, 4 6\n";
	arr[11] = " 1 10, 2 9, 3 8, 4 7, 5 6\n";
	arr[12] = " 1 11, 2 10, 3 9, 4 8, 5 7\n";

	for (int i = 0; i < n; i++) {
		int a;
		scanf("%d", &a);
		printf("Pairs for %d:", a);
		cout << arr[a];
	}
}