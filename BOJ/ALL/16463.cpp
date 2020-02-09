#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int Month[] = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
int now_year=2019, now_month=1, now_date=4;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int n,ans=0;
	scanf("%d", &n);

	while (now_year <= n) {
		if (now_date == 13) ans++;
		now_date += 7;
		
		if (now_date > Month[now_month]) {
			int now_month_last_date = Month[now_month];
			if (now_month == 2 && ((now_year % 400 == 0) || ((now_year % 100) && (now_year % 4 == 0))))
				now_month_last_date++;
			now_month++;
			now_date = now_date % now_month_last_date;
			if (now_month > 12) {
				now_year++;
				now_month = now_month % 12;
			}
		}
	}
	printf("%d\n", ans);
}