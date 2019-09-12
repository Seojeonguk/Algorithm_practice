#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char name[150], domi[150];
pair<int, int> cnt[4];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int n;
	scanf("%d", &n);
	while (n--) {
		memset(cnt, 0, sizeof cnt);
		scanf(" %s %s", name, domi);
		int s = strlen(domi);
		for (int i = 0; i < 4; i++) cnt[i].second = i;
		for (int i = 0; i < s; i++) {
			if (domi[i] == 'B') cnt[0].first+=2;
			else if (domi[i] == 'C') cnt[1].first+=1;
			else if (domi[i] == 'M') cnt[2].first+=4;
			else if (domi[i] == 'W') cnt[3].first+=3;
		}

		sort(cnt, cnt + 4);
		if (cnt[3].first == cnt[2].first) printf("%s: There is no dominant species\n", name);
		else if (cnt[3].second == 0) printf("%s: The Bobcat is the dominant species\n", name);
		else if (cnt[3].second == 1) printf("%s: The Coyote is the dominant species\n", name);
		else if (cnt[3].second == 2) printf("%s: The Mountain Lion is the dominant species\n", name);
		else if (cnt[3].second == 3) printf("%s: The Wolf is the dominant species\n", name);
	}
}