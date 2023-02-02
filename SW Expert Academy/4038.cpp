#include<cstdio>
#include<cstring>
#include<vector>
using namespace std;

int t;
char a[500002], b[500002];
int fail[500010];

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		vector<int> ans;
		memset(fail, 0, sizeof fail);

		scanf(" %s %s", b, a);

		int aLength = strlen(a);
		int bLength = strlen(b);

		for (int i = 1, j = 0; i < aLength; i++) {
			while (j > 0 && a[i] != a[j]) j = fail[j - 1];
			if (a[i] == a[j]) fail[i] = ++j;
		}


		for (int i = 0, j = 0; i < bLength; i++) {
			while (j > 0 && b[i] != a[j]) j = fail[j - 1];

			if (b[i] == a[j]) {
				if (j == aLength - 1) {
					ans.push_back(i - aLength + 2);
					j = fail[j];
				}
				else j++;
			}
		}

		printf("#%d %d\n", tc, ans.size());
	}
}
