#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char arr[1002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%s", arr);
	int size = strlen(arr);
	int cnt = 0;
	for (int i = 0; i<size; i++) {
		if (arr[i] == 'Y') {
			cnt++;
			for (int j = i; j < size; j += (i+1))
				if (arr[j] == 'Y') arr[j] = 'N';
				else if (arr[j] == 'N') arr[j] = 'Y';
		}
	}
	bool chk = true;
	for (int i = 0; i < size; i++)
		if (arr[i] == 'Y') {
			chk = false;
			break;
		}

	printf("%d\n", chk ? cnt : -1);
}