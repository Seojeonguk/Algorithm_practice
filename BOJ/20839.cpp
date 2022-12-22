#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int criterias[3];
int students[3];

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    for (int i = 0; i < 3; i++) {
        scanf("%d", &criterias[i]);
    }

    for (int i = 0; i < 3; i++) {
        scanf("%d", &students[i]);
    }

    if (students[1] >= criterias[1]) {
        if (students[0] >= criterias[0]) {
            puts("A");
        }
        else if (students[0] >= (criterias[0] + 1) / 2) {
            puts("B");
        }
        else {
            puts("C");
        }
    }
    else if (students[1] >= (criterias[1] + 1) / 2) {
        puts("D");
    }
    else puts("E");
}