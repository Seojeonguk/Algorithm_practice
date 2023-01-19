#define MAX_NODE 10000

struct Node {
	int data;
	Node* prev;
	Node* next;
};

Node node[MAX_NODE];
int nodeCnt;
Node head;

Node* getNode(int data) {
	node[nodeCnt].data = data;
	node[nodeCnt].prev = nullptr;
	node[nodeCnt].next = nullptr;
	return &node[nodeCnt++];
}

void init() {
	head.prev = head.next = nullptr;
	nodeCnt = 0;
}

void addNode2Head(int data) {
	Node* newNode = getNode(data);
	newNode->prev = &head;
	newNode->next = head.next;

	if(head.next!=nullptr)
		head.next->prev = newNode;
	head.next = newNode;
}

void addNode2Tail(int data) {
	Node* newNode = getNode(data);
	Node* node = &head;
	while (node->next != nullptr)
		node = node->next;

	newNode->prev = node;
	node->next = newNode;
}

void addNode2Num(int data, int num){
	Node* newNode = getNode(data);
	Node* node = &head;
	for (int i = 1; i < num; i++)
		node = node->next;

	newNode->next = node->next;
	newNode->prev = node;

	node->next = newNode;
	if (newNode->next != nullptr)
		newNode->next->prev = newNode;
	
}

int findNode(int data){
	int idx = 0;
	Node* node = &head;

	while (node != nullptr && node->data != data) {
		node = node->next;
		idx++;
	}
	return idx;
}

void removeNode(int data) {
	Node* node = &head;

	while (node->next != nullptr && node->next->data != data)
		node = node->next;

	if (node->next != nullptr) {
		node->next = node->next->next;
		if(node->next!=nullptr) 
			node->next->prev = node;
	}
	else {
		node->next = nullptr;
	}
}

int getList(int output[MAX_NODE]) {
	int cnt = 0;
	Node* node = head.next;
	while (node != nullptr) {
		output[cnt++] = node->data;
		node = node->next;
	}
	return cnt;
}

int getReversedList(int output[MAX_NODE]) {
	int cnt = 0;
	Node* node = &head;
	while (node->next != nullptr)
		node = node->next;

	while (node->prev != nullptr) {
		output[cnt++] = node->data;
		node = node->prev;
	}
	return cnt;
}