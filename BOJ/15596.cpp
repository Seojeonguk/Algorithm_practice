#include <vector>
long long sum(std::vector<int> &a) {
	long long ans = 0;
	int s = a.size();
	for (int i = 0; i < s; i++)
		ans += a[i];
	return ans;
}
