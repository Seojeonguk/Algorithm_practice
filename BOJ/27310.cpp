#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

char emoji[34];
int difficulty, length, underber_cnt;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%s", emoji);

	for (length = 0; emoji[length]; length++) {
		if (emoji[length] == ':')
			difficulty++;
		if (emoji[length] == '_')
			underber_cnt++;
	}

	printf("%d\n", length + difficulty + underber_cnt * 5);
}
