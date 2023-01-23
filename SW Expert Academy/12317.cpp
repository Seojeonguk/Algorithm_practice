int relations[100][6], s[41];
int sIdx = -1;
int spop() { return s[sIdx--]; }
void spush(int v) { s[++sIdx] = v; }
bool sempty() { return sIdx == -1; }
void sinit() { sIdx = -1; }

void dfs_init(int N, int path[100][2]) {
	for (int i = 0; i < 100; i++) 
		relations[i][0] = 0;

	for (int i = 0; i < 100; i++) {
		if (path[i][0] <= 0) break;
		int parent = path[i][0];
		int child = path[i][1];

		relations[parent][++relations[parent][0]] = child;
	}
}

int dfs(int n) {
	sinit();
	spush(n);
	while (!sempty()) {
		int parent = spop();

		if (parent > n) return parent;

		for (int i = relations[parent][0]; i > 0; i--)
			spush(relations[parent][i]);
	}

	return -1;
}
