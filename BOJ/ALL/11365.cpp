#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif]
	char arr[10001];
	while (1) {
		gets(arr);
		if (arr[0] == 'E' && arr[1] == 'N' && arr[2] == 'D')
			break;
		reverse(arr, arr + strlen(arr));
		puts(arr);
	}
}