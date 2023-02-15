#include<cstdio>
#define SOLDIER_MAX 100000
#define TEAM_MAX 5
#define SCORE_MAX 5
struct Soldier {
    int id, team;
    Soldier* prev;
    Soldier* next;
}soldiers[SOLDIER_MAX + 1];

Soldier teamsHead[TEAM_MAX + 1][SCORE_MAX + 1];
Soldier teamsTail[TEAM_MAX + 1][SCORE_MAX + 1];

void init() {
    for (int i = 1; i <= TEAM_MAX; i++) {
        for (int j = 1; j <= SCORE_MAX; j++) {
            teamsHead[i][j].next = &teamsTail[i][j];
            teamsTail[i][j].prev = &teamsHead[i][j];
        }
    }
}

void add(int id, int team, int score) {
    soldiers[id].prev = &teamsHead[team][score];
    soldiers[id].next = teamsHead[team][score].next;

    teamsHead[team][score].next = &soldiers[id];
    soldiers[id].next->prev = &soldiers[id];
}

void hire(int mID, int mTeam, int mScore){
    soldiers[mID].id = mID;
    soldiers[mID].team = mTeam;

    add(mID, mTeam, mScore);
}

void fire(int mID) {
    soldiers[mID].prev->next = soldiers[mID].next;
    soldiers[mID].next->prev = soldiers[mID].prev;

    soldiers[mID].prev = soldiers[mID].next = nullptr;
}

void updateSoldier(int mID, int mScore) {
    soldiers[mID].prev->next = soldiers[mID].next;
    soldiers[mID].next->prev = soldiers[mID].prev;

    add(mID, soldiers[mID].team, mScore);
}

void update(int team, int score, int targetScore) {
    Soldier* head = teamsHead[team][score].next;
    Soldier* tail = teamsTail[team][score].prev;

    teamsHead[team][score].next = &teamsTail[team][score];
    teamsTail[team][score].prev = &teamsHead[team][score];

    Soldier* targetTail = teamsTail[team][targetScore].prev;

    targetTail->next = head;
    head->prev = targetTail;

    tail->next = &teamsTail[team][targetScore];
    teamsTail[team][targetScore].prev = tail;
}

int calTargetScore(int score, int changeScore) {
    int targetScore = score + changeScore;
    if (targetScore > 5) targetScore = 5;
    else if (targetScore < 1) targetScore = 1;

    return targetScore;
}

void updateTeam(int mTeam, int mChangeScore) {
    for (int i = 1; i <= SCORE_MAX; i++) {
        int score = (mChangeScore < 0 ? i : 6 - i);
        int targetScore = calTargetScore(score, mChangeScore);

        if (targetScore == score || !teamsHead[mTeam][score].next->id) continue;

        update(mTeam, score, targetScore);
    }
}

int bestSoldier(int mTeam) {
    int maxSoldierID = 0;

    int teamIdx = 0;
    for (int i = SCORE_MAX; i >= 1; i--) {
        if (teamsHead[mTeam][i].next->id) {
            teamIdx = i;
            break;
        }
    }
    Soldier* soldier = teamsHead[mTeam][teamIdx].next;

    while (soldier->id) {
        if (maxSoldierID < soldier->id)
            maxSoldierID = soldier->id;
        soldier = soldier->next;
    }

    return maxSoldierID;
}
