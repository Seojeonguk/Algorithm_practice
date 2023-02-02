#include<iostream>
#include<set>
using namespace std;

int t, n, m;
string str;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> t;

    for (int tc = 1; tc <= t; tc++) {
        set<string> s;
        int ans = 0;
        cin >> n >> m;

        for (int i = 0; i < n; i++) {
            cin >> str;

            s.insert(str);
        }

        for (int i = 0; i < m; i++) {
            cin >> str;

            if (s.find(str) != s.end())
                ans++;

        }

        cout << "#" << tc << " " << ans << "\n";
    }
}
