#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

char tree[40];
int tree_cnt;

struct Trie {
	int last_cnt = 0;
	Trie *trie['z' + 1] = { nullptr, };
	void insert(char *str) {
		if (*str == '\0') {
			tree_cnt++;
			last_cnt++;
		}
		else {
			int next_idx = *str - ' ';
			if (trie[next_idx] == NULL) trie[next_idx] = new Trie;
			trie[next_idx]->insert(str + 1);
		}
	}

	void print(int pos = 0) {
		if (last_cnt > 0) {
			tree[pos] = '\0';
			printf("%s %.4lf\n", tree, 100.0*last_cnt / tree_cnt);
		}
		for (int i = 0; i < 'z' + 1; i++) {
			if (trie[i] != NULL) {
				tree[pos] = i + ' ';
				trie[i]->print(pos + 1);
			}
		}
	}
};

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	Trie *root = new Trie;
	while (gets(tree)) root->insert(tree);
	root->print();
}