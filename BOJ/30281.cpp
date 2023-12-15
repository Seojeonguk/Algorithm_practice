#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, candy, tookCandy;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d", &n);
    vector<int> v;
    for (int i = 0; i < n; i++) {
        scanf("%d", &candy);
        if (candy & 1) {
            v.push_back(candy);
        }
        else {
            tookCandy += candy;
        }
    }
    sort(v.begin(), v.end(), greater<>());
    int size = v.size();
    if (size & 1) {
        size--;
    }

    for (int i = 0; i < size; i++) {
        tookCandy += v[i];
    }

    printf("%d\n", tookCandy / 2);
}