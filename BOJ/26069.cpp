#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

bool isDancer(string);
int recordCnt;
set<string> dancers;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &recordCnt);

    string chongchongName = "ChongChong";
    dancers.insert(chongchongName);

    for (int idx = 0; idx < recordCnt; idx++) {
        string AName, BName;
        cin >> AName >> BName;
        if (!isDancer(AName) && !isDancer(BName)) {
            continue;
        }
        dancers.insert(AName);
        dancers.insert(BName);
    }
    printf("%d\n", dancers.size());
}

bool isDancer(string name) {
    return dancers.find(name) != dancers.end();
}