#define HASH_MAX 17576
#define CHAR_MAX 50000
int N;
char str[CHAR_MAX+1];

struct Node {
	int idx;
	Node* prev;
	Node* next;
};

Node nodes[CHAR_MAX + 1];
Node hashTable[HASH_MAX];

Node* createNode(int idx) {
	nodes[idx].idx = idx;
	nodes[idx].prev = nodes[idx].next = nullptr;

	return &nodes[idx];
}

void addNode(int hash, int idx) {
	Node* newNode = createNode(idx);

	newNode->next = hashTable[hash].next;
	newNode->prev = &hashTable[hash];
	hashTable[hash].next = newNode;
	if (newNode->next) {
		newNode->next->prev = newNode;
	}
}

int convertHash(char str[]) {
	int hash = str[0] - 'a';
	hash = hash * 26 + str[1] - 'a';
	hash = hash * 26 + str[2] - 'a';

	return hash;
}

void insertHash(Node* insertNode, int hash) {
	Node* node = &hashTable[hash];

	while (node->next) {
		if (node->next->idx > insertNode->idx) break;
		node = node->next;
	}

	insertNode->prev = node;
	insertNode->next = node->next;

	node->next = insertNode;

	
	if (insertNode->next)
		insertNode->next->prev = insertNode;
}

void init(int n, char init_string[]) {
	N = n;

	for (int i = 0; i < HASH_MAX; i++)
		hashTable[i].next = nullptr;

	for (int i = 0; i < N; i++)
		str[i] = init_string[i];
	str[N] = '\0';

	for (int i = N - 3; i >= 0; i--) {
		int hash = convertHash(init_string + i);
		addNode(hash, i);
	}
}

int change(char string_A[], char string_B[]) {
	int AHash = convertHash(string_A);
	int cnt = 0;
	Node* node = hashTable[AHash].next;
	hashTable[AHash].next = nullptr;
	int start = -1, end = -1;
	while (node) {
		node->prev = nullptr;

		cnt++;

		Node* tmp = node;
		while (tmp) {
			if (tmp->idx >= node->idx + 3) break;
			tmp = tmp->next;
		}

		for (int i = 0; i < 3; i++)
			str[node->idx + i] = string_B[i];

		start = (node->idx >= 2 ? node->idx - 2 : 0);
		end = (node->idx + 2 >= N - 3 ? N - 3 : node->idx + 2);
		for (int i = start; i <= end; i++) {
			int hash = convertHash(str + i);
			if (nodes[i].prev) nodes[i].prev->next = nodes[i].next;
			if (nodes[i].next) nodes[i].next->prev = nodes[i].prev;

			insertHash(nodes + i, hash);
		}

		node = tmp;
	}

	return cnt;
}

void result(char ret[]) {
	for (int i = 0; i < N; i++)
		ret[i] = str[i];
	ret[N] = '\0';
}