#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int w, X[] = { 1,0,-1,0,1,1,-1,-1 }, Y[] = { 0,1,0,-1,1,-1,1,-1 }, score[] = { 0,0,0,1,1,2,3,5,11 };
char c[10], boggle[5][5];
bool visit[5][5];
set<string> s;

struct Trie {
	bool last = false;
	Trie *trie[26] = { NULL, };
	void insert(char *str) {
		if (*str == '\0') last = true;
		else {
			int next_idx = *str - 'A';
			if (trie[next_idx] == NULL) trie[next_idx] = new Trie;
			trie[next_idx]->insert(str + 1);
		}
	}
	void find(int x, int y, string str) {
		if (x < 0 || y < 0 || x >= 4 || y >= 4 || visit[x][y]) return;
		if (str.size() >= 8) return;

		visit[x][y] = true;
		str = str + boggle[x][y];

		if (trie[boggle[x][y] - 'A'] == NULL) {
			visit[x][y] = false;
			return;
		}

		if (trie[boggle[x][y] - 'A']->last) s.insert(str);

		for (int i = 0; i < 8; i++)
			trie[boggle[x][y] - 'A']->find(x + X[i], y + Y[i], str);
		visit[x][y] = false;
	}
};

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	Trie *root = new Trie;
	scanf("%d", &w);
	getchar();
	for (int i = 0; i < w; i++) {
		scanf("%s", c);
		root->insert(c);
	}

	for (scanf("%d", &w); w--;) {
		string ans = "";
		int ans_score = 0;
		s.clear();

		for (int i = 0; i < 4; i++) scanf(" %s", boggle[i]);

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				root->find(i, j, "");

		for (auto x : s) {
			if (ans.size() < x.size())
				ans = x;
			ans_score += score[x.size()];
		}
		printf("%d ", ans_score);
		cout << ans;
		printf(" %d\n", s.size());
	}

}