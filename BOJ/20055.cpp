#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k;
int zeroDurabilityCnt;
vector<int> durabilities;
vector<bool> isOn;
queue<int> q;

void rotateBelt() {
    rotate(durabilities.rbegin(), durabilities.rbegin() + 1, durabilities.rend());

    int qSize = q.size();

    while (qSize--) {
        isOn[q.front()] = false;
        int nextIdx = q.front() + 1;
        q.pop();
        if (nextIdx == n - 1) continue;
        isOn[nextIdx] = true;
        q.push(nextIdx);
    }
}

void moveRobot() {
    int qSize = q.size();
    while (qSize--) {
        int nextIdx = q.front() + 1;
        q.pop();

        if (isOn[nextIdx] || !durabilities[nextIdx]) {
            q.push(nextIdx - 1);
            continue;
        }

        isOn[nextIdx - 1] = false;
        int& nextDurability = durabilities[nextIdx];
        nextDurability--;
        if (!nextDurability) zeroDurabilityCnt++;

        if (nextIdx == n - 1) continue;
        q.push(nextIdx);
        isOn[nextIdx] = true;
    }
}

void putRobot() {
    int& zeroDurability = durabilities[0];

    if (isOn[0]) return;
    if (!zeroDurability) return;

    zeroDurability--;
    if (!zeroDurability) zeroDurabilityCnt++;
    isOn[0] = true;
    q.push(0);

}

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d", &n, &k);
    durabilities.resize(2 * n);
    isOn.resize(2 * n);


    for (int i = 0; i < 2 * n; i++)
        scanf("%d", &durabilities[i]);

    for (int stage = 1;; stage++) {
        rotateBelt();
        moveRobot();
        putRobot();

        if (zeroDurabilityCnt >= k) {
            printf("%d\n", stage);
            break;
        }
    }
}
