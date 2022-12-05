#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int gifticonCnt, availableGifticonCnt;
string giftconExpirationDate;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &gifticonCnt);
    cin.ignore();
    for (int idx = 0; idx < gifticonCnt; idx++) {
        getline(cin, giftconExpirationDate);
        int iExpirationDate = stoi(giftconExpirationDate.substr(2));
        if (iExpirationDate <= 90) {
            availableGifticonCnt++;
        }
    }
    printf("%d\n", availableGifticonCnt);
}