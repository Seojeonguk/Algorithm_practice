#include<iostream>
#include<set>
#include<cstring>
using namespace std;

int t, n;
string str;

struct customOrder {
	bool operator() (const string& a, const string& b) const {
		if (a.size() == b.size()) return a < b;
		return a.size() == b.size() ? a < b : a.size() < b.size();
	}
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> t;

	for (int tc = 1; tc <= t; tc++) {
		set<string, customOrder> s;
		cin >> n;

		for (int i = 0; i < n; i++) {
			cin >> str;

			s.insert(str);
		}

		cout << "#" << tc << "\n";

		for (auto it : s) {
			cout << it << "\n";
		}
	}
}
