#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;
pair<int, int> pos_idx[101];
string id_num[101],copy_id_num[101];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 1; i <= n; i++) {
		scanf("%d", &pos_idx[i].first);
		pos_idx[i].second = i;
	}

	for (int i = 1; i <= n; i++) {
		cin.ignore();
		cin >> id_num[i];
	}

	for (int k = 0; k < 3; k++) {
		for (int i = 1; i <= n; i++) {
			copy_id_num[pos_idx[i].second] = id_num[pos_idx[i].first];

		}
		for (int i = 1; i <= n; i++)
			id_num[i] = copy_id_num[i];
	}

	for (int i = 1; i <= n; i++)
		cout << copy_id_num[i] << "\n";
}