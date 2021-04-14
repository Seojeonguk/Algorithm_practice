#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;


int n, m,ans;
char arr[502];

struct Trie {
	bool last = false;
	Trie* trie[26] = { NULL, };
	void insert(char* str) {
		if (*str == '\0') last = true;
		else {
			int next_idx = *str - 'a';
			if (trie[next_idx] == NULL) trie[next_idx] = new Trie;
			trie[next_idx]->insert(str + 1);
		}
	}
	bool find(char* str) {
		if (*str == '\0') return last;
		char next_idx = *str - 'a';
		if (trie[next_idx] != NULL) {
			return trie[next_idx]->find(str + 1);
		}
		else return false;
	}
};

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	Trie* root = new Trie;
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) {
		scanf(" %s", arr);
		root->insert(arr);
	}

	for (int i = 0; i < m; i++) {
		scanf(" %s", arr);
		if (root->find(arr))
			ans++;
	}

	printf("%d\n", ans);
}