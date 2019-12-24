#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
char arr[5];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%s", arr);

	int len = strlen(arr);
	if (len == 2) printf("%d\n", arr[0] - '0' + arr[1] - '0');
	else if (len == 4) puts("20");
	else {
		if (arr[1] == '0') printf("%d\n", 10 + arr[2] - '0');
		else if (arr[2] == '0') printf("%d\n", 10 + arr[0] - '0');
	}
}