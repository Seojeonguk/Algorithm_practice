#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t1, t2, m1, m2;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    scanf("%d %d %d %d", &t1, &m1, &t2, &m2);

    m1 += t1 * 60;
    m2 += t2 * 60;

    if (m1 > m2)
        m2 += 24 * 60;

    printf("%d %d\n", m2 - m1, (m2 - m1) / 30);
}