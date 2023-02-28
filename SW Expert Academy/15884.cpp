#include<algorithm>
using namespace std;
#define PLAYER_MAX 100000
struct PLAYER {
	int p, score;
	PLAYER* prev;
	PLAYER* next;
}players[PLAYER_MAX + 1];

PLAYER heads[PLAYER_MAX + 1], tails[PLAYER_MAX + 1];

void init(int N){
	for (int i = 1; i <= N; i++) {
		players[i].p = i;
		players[i].prev = players[i].next = nullptr;
		players[i].score = 0;
		heads[i].score = 0;

		players[i].prev = &heads[i];
		players[i].next = &tails[i];
		heads[i].next = &players[i];
		tails[i].prev = &players[i];
	}
}

void updateScore(int mWinnerID, int mLoserID, int mScore){
	int w_idx = players[mWinnerID].p;
	int l_idx = players[mLoserID].p;

	heads[w_idx].score += mScore;
	heads[l_idx].score -= mScore;
}

void unionTeam(int mPlayerA, int mPlayerB){
	int a_p = players[mPlayerA].p;
	int b_p = players[mPlayerB].p;

	int minIdx = min(a_p, b_p);
	int maxIdx = max(a_p, b_p);

	PLAYER* head = heads[maxIdx].next;
	PLAYER* tail = tails[maxIdx].prev;
	heads[maxIdx].next = &tails[maxIdx];
	tails[maxIdx].prev = &heads[maxIdx];

	head->prev = tail->next = nullptr;

	PLAYER* player = head;
	while (player) {
		player->score += heads[maxIdx].score - heads[minIdx].score;
		player->p = minIdx;
		player = player->next;
	}

	tail->next = heads[minIdx].next;
	heads[minIdx].prev = tail;

	head->prev = &heads[minIdx];
	heads[minIdx].next = head;
}

int getScore(int mID){
	return players[mID].score + heads[players[mID].p].score;
}
