#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int r, c;
char joo[52][52];
int ans[5];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &r, &c);

	for (int i = 0; i < r; i++)
		scanf(" %s", joo[i]);

	for (int i = 0; i < r - 1; i++) {
		for (int j = 0; j < c - 1; j++) {
			int empty_space = 0;
			bool chk = true;
			if (joo[i][j] == '#' || joo[i + 1][j] == '#' || joo[i][j + 1] == '#' || joo[i + 1][j + 1] == '#') continue;
			
			if (joo[i][j] == '.') empty_space++;
			if (joo[i+1][j] == '.') empty_space++;
			if (joo[i][j+1] == '.') empty_space++;
			if (joo[i+1][j+1] == '.') empty_space++;

			ans[4-empty_space]++;
		}

	}

	for (int i = 0; i < 5; i++)
		printf("%d\n", ans[i]);
}