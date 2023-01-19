#define MAX_NODE 10000
struct Node {
	int data;
	Node* next;
};

Node node[MAX_NODE];
int nodeCnt;
Node head;

Node* getNode(int data) {
	node[nodeCnt].data = data;
	node[nodeCnt].next = nullptr;
	return &node[nodeCnt++];
}

void init() {
	head.next = nullptr;
	nodeCnt = 0;
}

void addNode2Head(int data) {
	Node* newNode = getNode(data);
	newNode->next = head.next;
	head.next = newNode;
}

void addNode2Tail(int data){
	Node* newNode = getNode(data);
	Node* lastNode = &head;
	while (lastNode->next != nullptr)
		lastNode = lastNode->next;
	lastNode->next = newNode;
}

void addNode2Num(int data, int num){
	Node* node = &head;
	for (int i = 1; i < num; i++)
		node = node->next;
	Node* newNode = getNode(data);
	newNode->next = node->next;
	node->next = newNode;
}

void removeNode(int data){
	Node* node = &head;
	while (node->next != nullptr && node->next->data != data) {
		node = node->next;
	}
	if (node->next != nullptr)
		node->next = node->next->next;

}

int getList(int output[MAX_NODE]){
	int cnt = 0;
	Node* node = head.next;
	while (node != nullptr) {
		output[cnt++] = node->data;
		node = node->next;
	}
	return cnt;
}