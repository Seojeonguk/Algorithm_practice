#include<queue>
#include<algorithm>
using namespace std;
#define MAX_CITY 200
typedef pair<int, int> pii;
typedef pair<int, pair<int, int> > pipii;

int n, m, totalTax;
bool isDispatch[MAX_CITY];
int taxes[MAX_CITY];
priority_queue<pii, vector<pii>, greater<pii> > grains[MAX_CITY];
priority_queue<pipii, vector<pipii>,greater<pipii> > officials;
priority_queue<pair<int, int> > predict;

int calPredictCity() {
    while (!predict.empty() && (isDispatch[-predict.top().second] || predict.top().first != taxes[-predict.top().second]))
        predict.pop();

    if (predict.empty() || !predict.top().first) return 0;
    return -predict.top().second;
}

void calDispatch(int curTime) {
    while (!officials.empty() && officials.top().first <= curTime) {
        int time = officials.top().first;
        int city = officials.top().second.first;
        int grain = officials.top().second.second;

        officials.pop();

        if (grain >= 0) {
            m++;
            totalTax += grain;
            isDispatch[city] = false;
            taxes[city] -= grain;
            predict.push({ taxes[city],-city });
        }
        else if (city >= 0) {
            int moveTax = 0;
            while (!grains[city].empty() && grains[city].top().first <= time) {
                moveTax += grains[city].top().second;
                grains[city].pop();
            }
            officials.push({ time + city,{city,moveTax} });
        }
        else {
            city = -city;
            grain = -grain;
            taxes[city] += grain;
            if (!isDispatch[city])
                predict.push({ taxes[city],-city });
        }

        if (officials.empty() || officials.top().first > time) {
            while (m > 0 && calPredictCity() > 0) {
                int city = calPredictCity();
                isDispatch[city] = true;
                officials.push({ time + city,{city,-1} });
                m--;
            }
        }
    }
}

void init(int N, int M) {
    n = N, m = M;
    totalTax = 0;

    for (int i = 1; i < n; i++) {
        while (!grains[i].empty()) grains[i].pop();
        isDispatch[i] = false;
        taxes[i] = 0;
    }

    while (!officials.empty()) officials.pop();
    while (!predict.empty()) predict.pop();
}

void destroy() {}


int order(int tStamp, int mCityA, int mCityB, int mTax) {
    grains[mCityB].push({ tStamp + abs(mCityA - mCityB),mTax });
    officials.push({ tStamp + max(0,abs(mCityA - mCityB) - mCityB),{-mCityB,-mTax} });
    calDispatch(tStamp);
    return totalTax;
}

int check(int tStamp) {
    calDispatch(tStamp);
    return totalTax;
}