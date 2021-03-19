#include <iostream>
#include <vector>
using namespace std;
int n, cnt;
double sum, x;
vector<double> v;

int main() {
	scanf("%d", &n);
	for (int i = 0; i < n; i++) {
		scanf("%lf", &x);
		sum += x;
		v.push_back(x);
	}
	double middle = (double)(sum / n);
	for (int i = 0; i < n; i++)
		if (middle < v[i])
			cnt++;

	printf("%.1lf %d", middle, cnt);
}