#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char arr[602];
int n, m;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%s", arr);
	int size = strlen(arr);

	for (int i = 0; i < size; i++) {
		if (arr[i] == '0') n++;
		else m++;
	}

	n /= 2, m /= 2;
	for (int i = 0; i < size && m != 0; i++)
		if (arr[i] == '1') {
			arr[i] = 0;
			m--;
		}

	for (int i = size - 1; i >= 0 && n != 0; i--)
		if (arr[i] == '0') {
			arr[i] = 0;
			n--;
		}

	for (int i = 0; i < size; i++)
		if (arr[i] != 0)
			printf("%c", arr[i]);
}