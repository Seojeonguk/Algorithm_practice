#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int t, cost, totalAreaOfRoom, totalAreaofBedRoom, roomSize;
string room;
double totalArea;

int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
    cin >> t >> cost;

    while (t--) {
        cin >> roomSize >> room;
        totalAreaOfRoom += roomSize;
        if (!room.compare("bedroom"))
            totalAreaofBedRoom += roomSize;
        
        if (!room.compare("balcony")) totalArea += roomSize / 2.0;
        else totalArea += roomSize;
    }

    printf("%d\n%d\n%lf", totalAreaOfRoom, totalAreaofBedRoom, totalArea * cost);
}
