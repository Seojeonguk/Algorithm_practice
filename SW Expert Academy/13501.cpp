#include<cstdio>
#include<vector>
using namespace std;
typedef long long ll;

int t, n, m, x, y, l;
char c;

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d %d %d", &n, &m, &l);

        vector<int> v(n);
        for (int i = 0; i < n; i++)
            scanf("%d", &v[i]);

        while (m--) {
            scanf(" %c", &c);
            if (c == 'I') {
                scanf("%d %d", &x, &y);

                v.insert(v.begin() + x, y);
            }
            else if (c == 'D') {
                scanf("%d", &x);
                v.erase(v.begin() + x, v.begin() + x + 1);
            }
            else if (c == 'C') {
                scanf("%d %d", &x, &y);
                v[x] = y;
            }
        }
        
        printf("#%d %d\n", tc, v.size() <= l ? -1 : v[l]);
    }
}