#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

string first_name, first_gender,other_name,other_gender;
int first_dist,other_dist;
int n;
vector<string> v;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cin >> first_name >> first_gender >> first_dist;
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		cin >> other_name >> other_gender >> other_dist;
		if ((first_gender == other_gender || first_gender.size() == 2) && first_dist >= other_dist)
			v.push_back(other_name);
	}

	if (!v.empty()) {
		sort(v.begin(), v.end());
		int size = v.size();

		for (int i = 0; i < size; i++)
			cout << v[i] << "\n";
	}
	else puts("No one yet");
}