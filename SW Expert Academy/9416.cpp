#define USER_MAX 1000
#define FEED_MAX 100000
struct Node {
	int uID;
	int pID;
	int timeStamp;
	int likes;
	Node* prev;
	Node* next;
};

Node feeds[FEED_MAX+1];
bool isFollows[USER_MAX+1][USER_MAX+1];
Node root;

void init(int N) {
	for (int i = 0; i <= N; i++) {
		for (int j = 0; j <= N; j++) {
			isFollows[i][j] = false;
		}
		isFollows[i][i] = true;
	}
	root.next = nullptr;
}

void follow(int uID1, int uID2, int timestamp) {
	isFollows[uID1][uID2] = true;
}

void makePost(int uID, int pID, int timestamp){
	Node* feed = &feeds[pID];
	feed->uID = uID;
	feed->pID = pID;
	feed->timeStamp = timestamp;
	feed->likes = 0;

	feed->next = root.next;
	feed->prev = &root;
	root.next = feed;
	if (feed->next)
		feed->next->prev = feed;
}

void like(int pID, int timestamp) {
	feeds[pID].likes++;
}

void getFeed(int uID, int timestamp, int pIDList[]){
	int insertCnt = 0;
	Node* node = root.next;

	while (node) {
		if (!isFollows[uID][node->uID]) {
			node = node->next;
			continue;
		}

		if (node->timeStamp < timestamp - 1000) {
			if (insertCnt == 10) break;
			pIDList[insertCnt++] = node->pID;
			node = node->next;
			continue;
		}

		int insertIdx = insertCnt;
		for (int i = 0; i < insertCnt; i++) {
			if (feeds[pIDList[i]].likes < node->likes) {
				insertIdx = i;
				break;
			}
		}

		for (int i = 9; i > insertIdx; i--) {
			pIDList[i] = pIDList[i - 1];
		}

		if(insertIdx<10) 
			pIDList[insertIdx] = node->pID;

		if (insertCnt < 10) {
			insertCnt++;
		}
			
		node = node->next;
	}
}