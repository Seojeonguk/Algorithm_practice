#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

void calEdibleCnt(int);
vector<long long> wants, mealTickets;
long long answer;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int idx = 0; idx < 3; idx++) {
        long long wantCnt;
        scanf("%lld", &wantCnt);
        wants.push_back(wantCnt);
    }

    for (int idx = 0; idx < 3; idx++) {
        long long mealTicketCnt;
        scanf("%lld", &mealTicketCnt);
        mealTickets.push_back(mealTicketCnt);
    }

    int mostTicketsLeftIdx = 0;
    for (int idx = 0; idx < 3; idx++) {
        calEdibleCnt(idx);
        if (mealTickets[idx] > mealTickets[mostTicketsLeftIdx]) {
            mostTicketsLeftIdx = idx;
        }
    }

    int nowIdx = mostTicketsLeftIdx;
    while (mealTickets[nowIdx] / 3) {
        int nextIdx = (nowIdx + 1) % 3;
        long long exchangeCnt = mealTickets[nowIdx] / 3;
        mealTickets[nowIdx] -= exchangeCnt * 3;
        mealTickets[nextIdx] += exchangeCnt;
        calEdibleCnt(nextIdx);
        nowIdx = (nowIdx + 1) % 3;
    }
    printf("%lld\n", answer);
}

void calEdibleCnt(int idx) {
    long long edibleCnt = min(wants[idx], mealTickets[idx]);
    answer += edibleCnt;
    wants[idx] -= edibleCnt;
    mealTickets[idx] -= edibleCnt;
}