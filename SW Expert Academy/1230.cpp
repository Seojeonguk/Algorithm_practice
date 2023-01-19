#include<cstdio>
#include<vector>
using namespace std;
typedef long long ll;

int t, n, m, x, y, s;
char c;

int main() {
    t = 10;

    for (int tc = 1; tc <= t; tc++) {
        scanf("%d", &n);

        vector<int> v(n);
        for (int i = 0; i < n; i++)
            scanf("%d", &v[i]);

        scanf("%d", &m);
        while (m--) {
            scanf(" %c", &c);
            if (c == 'I') {
                scanf("%d %d", &x, &y);

                for (int i = 0; i < y; i++) {
                    scanf("%d", &s);
                    v.insert(v.begin() + x + i, s);
                }
            }
            else if (c == 'D') {
                scanf("%d %d", &x, &y);
                v.erase(v.begin() + x, v.begin() + x + y);
            }
            else if (c == 'A') {
                scanf("%d", &y);

                for (int i = 0; i < y; i++) {
                    scanf("%d", &s);
                    v.push_back(s);
                }
            }
        }

        printf("#%d ", tc);
        int size = v.size();
        for (int i = 0; i < min(10,size); i++)
            printf("%d ", v[i]);
        puts("");
    }
}