#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

ll money;
ll tanker, dealer;
ll tankerCost, dealerCost;
ll ansTanker, ansDealer;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%lld", &money);
    scanf("%lld %lld", &tanker, &tankerCost);
    scanf("%lld %lld", &dealer, &dealerCost);

    for (ll nowTankerCnt = 0; nowTankerCnt <= money / tankerCost; nowTankerCnt++) {
        ll nowDealerCnt = (money - nowTankerCnt * tankerCost) / dealerCost;

        ll power = nowTankerCnt * tanker + nowDealerCnt * dealer;
        ll ansPower = ansTanker * tanker + ansDealer * dealer;
        if (ansPower < power) {
            ansTanker = nowTankerCnt;
            ansDealer = nowDealerCnt;
        }
    }

    printf("%lld %lld\n", ansTanker, ansDealer);
}