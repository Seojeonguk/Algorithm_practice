#include<cstdio>
#include<cstring>
using namespace std;
typedef long long ll;

int t, cases[10001][16];
char managers[10001];
int MOD = 1000000007;

int main() {
    scanf("%d", &t);

    for (int tc = 1; tc <= t; tc++) {
        memset(cases, 0, sizeof cases);
        scanf(" %s", managers);

        int managersLength = strlen(managers);
        cases[0][1] = 1;
        for (int idx = 1; idx <= managersLength; idx++) {
            int manager = (1 << (managers[idx - 1] - 'A'));

            for (int participants = 1; participants < 16; participants++) {
                if (!(participants & manager)) continue;
                for (int prevParticipants = 1; prevParticipants < 16; prevParticipants++) {
                    if (!(prevParticipants & participants)) continue;

                    cases[idx][participants] += cases[idx - 1][prevParticipants];
                    cases[idx][participants] %= MOD;
                }
            }
        }

        int ans = 0;
        for (int i = 1; i < 16; i++) {
            ans += cases[managersLength][i];
            ans %= MOD;
        }
        printf("#%d %d\n", tc, ans);
    }
}