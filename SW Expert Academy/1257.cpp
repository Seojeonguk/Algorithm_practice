#include<cstdio>
#include<cstring>
using namespace std;

int t, k, cnt;
char arr[402], brr[402];
char ans[402];

struct Trie {
	bool last = false;
	Trie* trie[26] = { NULL, };
	void insert(char* str) {
		if (*str == '\0') last = true;
		else {
			char next_idx = *str - 'a';
			if (trie[next_idx] == NULL) trie[next_idx] = new Trie;
			trie[next_idx]->insert(str + 1);
		}
	}

	bool find(int idx) {
		if (last) cnt++;
		if (cnt == k) return true;

		for (int i = 0; i < 26; i++) {
			if (trie[i] == NULL) continue;
			ans[idx] = 'a' + i;
			bool isFind = trie[i]->find(idx + 1);
			if (isFind) return true;
			ans[idx] = '\0';
		}

		return false;
	}
};

int main() {
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
        memset(ans, '\0', sizeof ans);
		cnt = 0;
		Trie trie;
		scanf("%d %s", &k, arr);

		int size = strlen(arr);
		for (int i = 0; arr[i]; i++) {
			for (int j = 1; j <= size - i; j++) {
				int idx = 0,jtmp = j;
				while (jtmp--) {
					brr[idx++] = arr[i+idx];
				}
				brr[idx] = '\0';
				trie.insert(brr);
			}
		}

		bool isFind = trie.find(0);

		printf("#%d %s\n", tc, isFind ? ans : "none");
	}
}