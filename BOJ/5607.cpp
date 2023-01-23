#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, ACard, BCard, AScore, BScore;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &t);

    while (t--) {
        scanf("%d %d", &ACard, &BCard);
        if (ACard < BCard) BScore += ACard + BCard;
        else if (ACard > BCard) AScore += ACard + BCard;
        else AScore += ACard, BScore += BCard;
    }

    printf("%d %d\n", AScore, BScore);
}
