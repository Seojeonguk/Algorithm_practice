#include<cstdio>
using namespace std;
typedef long long ll;

int t, n, m;
bool isOn;

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d %d", &n, &m);

        int last = (1 << n) - 1;
        if ((last & m) == last) isOn = true;
        else isOn = false;

        printf("#%d %s\n", tc, isOn ? "ON" : "OFF");
    }
}