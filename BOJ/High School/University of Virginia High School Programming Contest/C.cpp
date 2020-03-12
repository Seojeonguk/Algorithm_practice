#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)

int t, grade;

using namespace std;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif]
	scanf("%d", &t);

	while (t--) {
		string a;
		cin >> a;
		scanf("%d", &grade);
		cout << a;
		printf(" ");
		switch (grade / 10) {
		case 10:
			printf("A+");
			break;
		case 9:
			printf("A");
			if (grade % 10 > 6)
				printf("+");
			break;
		case 8:
			printf("B");
			if (grade % 10 > 6)
				printf("+");
			break;
		case 7:
			printf("C");
			if (grade % 10 > 6)
				printf("+");
			break;
		case 6:
			printf("D");
			if (grade % 10 > 6)
				printf("+");
			break;
		default:
			printf("F");
			break;
		}
		printf("\n");
	}
}