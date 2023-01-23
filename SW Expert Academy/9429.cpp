#define NAME_MAXLEN 6
#define PATH_MAXLEN 1999
#define DIRECTORY_MAXLEN 50000
#define DIRECTORY_NAME_MAXLEN 6
#define DIRECTORY_CHILD_MAXLEN 30

#include<vector>
using namespace std;

struct Dir {
	long long name;
	Dir* next[DIRECTORY_CHILD_MAXLEN];
	int childCnt;
};

Dir dir[DIRECTORY_MAXLEN];
int dirCnt;
Dir head;

long long charToIntn(const char* a, int len) {
	long long ret = 0;
	for (int i = 0; i < len; i++) {
		ret = ret * 1000 + a[i];
	}
	return ret;
}

long long charToInt(const char* a) {
	long long ret = 0;
	int i = 0;
	while (a[i] != '\0') {
		ret = ret * 1000 + a[i];
		i++;
	}
	return ret;
	
}

vector<int> getSlashs(const char* a) {
	vector<int> slashes;
	int idx = 0;

	while (a[idx] != '\0') {
		if (a[idx] == '/')
			slashes.push_back(idx);
		idx++;
	}

	return slashes;
}

void init(int n) {
	dirCnt = head.childCnt = 0;

	for (int j = 0; j < DIRECTORY_NAME_MAXLEN; j++)
		head.name = 0;
	for (int j = 0; j < DIRECTORY_CHILD_MAXLEN; j++)
		head.next[j] = nullptr;
}

Dir* createNewDir(long long name, int childCnt) {
	dir[dirCnt].name = name;
	dir[dirCnt].childCnt = childCnt;
	for (int i = 0; i < DIRECTORY_CHILD_MAXLEN; i++)
		dir[dirCnt].next[i] = nullptr;
	return &dir[dirCnt++];
}

Dir* targetSubTree(const char* c,int cnt) {
	Dir* ret = &head;
	vector<int> slashs = getSlashs(c);
	int slashsSize = slashs.size();

	for (int i = 1; i < slashsSize; i++) {
		long long nextName = charToIntn(c + slashs[i - 1] + 1, slashs[i] - slashs[i - 1] - 1);
		ret->childCnt += cnt;

		for (int j = 0; j < DIRECTORY_CHILD_MAXLEN; j++) {
			if (ret->next[j] != nullptr && ret->next[j]->name == nextName) {
				ret = ret->next[j];
				break;
			}
		}
	}
	ret->childCnt += cnt;

	return ret;
}

pair<Dir*, int> targetSubTree2(const char* c,int cnt) {
	int targetIdx = 0;
	Dir* ret = &head;
	vector<int> slashs = getSlashs(c);
	int slashsSize = slashs.size();

	for (int i = 1; i < slashsSize; i++) {
		long long nextName = charToIntn(c + slashs[i - 1] + 1, slashs[i] - slashs[i - 1] - 1);
		ret->childCnt += cnt;

		for (int j = 0; j < DIRECTORY_CHILD_MAXLEN; j++) {
			if (ret->next[j] != nullptr && ret->next[j]->name == nextName) {
				if (i == slashsSize - 1) targetIdx = j;
				else ret = ret->next[j];
				break;
			}
		}
	}

	return { ret,targetIdx };
}

void cmd_mkdir(char path[PATH_MAXLEN + 1], char name[NAME_MAXLEN + 1]) {
	long long llName = charToInt(name);
	Dir* newDir = createNewDir(llName,0);

	Dir* d = targetSubTree(path, 1);

	for (int i = 0; i < DIRECTORY_CHILD_MAXLEN; i++) {
		if (d->next[i] == nullptr) {
			d->next[i] = newDir;
			break;
		}
	}
}

void cmd_rm(char path[PATH_MAXLEN + 1]) {
	pair<Dir*, int> pathInfo = targetSubTree2(path, 0);

	int removeCnt = pathInfo.first->next[pathInfo.second]->childCnt+1;
	pathInfo.first->next[pathInfo.second] = nullptr;

	targetSubTree2(path, -removeCnt);
}

Dir* createcp(Dir* dir) {
	Dir* newDir = createNewDir(dir->name,dir->childCnt);

	for (int i = 0; i < DIRECTORY_CHILD_MAXLEN; i++) 
		if (dir->next[i] != nullptr) 
			newDir->next[i] = createcp(dir->next[i]);

	return newDir;
}

void cmd_cp(char srcPath[PATH_MAXLEN + 1], char dstPath[PATH_MAXLEN + 1]) {
	pair<Dir*, int> srcInfo = targetSubTree2(srcPath, 0);

	int copyCnt = srcInfo.first->next[srcInfo.second]->childCnt + 1;
	Dir* dst = targetSubTree(dstPath, copyCnt);
	Dir* next = createcp(srcInfo.first->next[srcInfo.second]);

	for (int i = 0; i < DIRECTORY_CHILD_MAXLEN; i++) {
		if (dst->next[i] == nullptr) {
			dst->next[i] = next;
			break;
		}
	}
}

void cmd_mv(char srcPath[PATH_MAXLEN + 1], char dstPath[PATH_MAXLEN + 1]) {
	pair<Dir*, int > srcInfo = targetSubTree2(srcPath, 0);

	int moveCnt = srcInfo.first->next[srcInfo.second]->childCnt+1;
	targetSubTree2(srcPath, -moveCnt);

	Dir* dst = targetSubTree(dstPath, moveCnt);

	for (int i = 0; i < DIRECTORY_CHILD_MAXLEN; i++) {
		if (dst->next[i] == nullptr) {
			dst->next[i] = srcInfo.first->next[srcInfo.second];
			srcInfo.first->next[srcInfo.second] = nullptr;
			break;
		}
	}
}

int cmd_find(char path[PATH_MAXLEN + 1]) {
	Dir* d = targetSubTree(path, 0);

	return d->childCnt;
}