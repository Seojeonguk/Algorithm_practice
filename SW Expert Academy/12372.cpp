int incomes[10];
int uIDs[10];
int cnt;
void init() {
    cnt = 0;
    for(int i=0;i<10;i++) {
        incomes[i] = 0;
        uIDs[i] = 0;
    }
}

void addUser(int uID, int height)  {
    if(cnt==10) {
        int idx=0;
        for(int i=0;i<cnt;i++) {
            if(incomes[idx]>incomes[i]) {
                idx = i;
            } else if(incomes[idx]==incomes[i]) {
                if(uIDs[idx] < uIDs[i]) {
                    idx = i;
            	}
        	}
        }
        if (incomes[idx] < height) {
            incomes[idx] = height;
            uIDs[idx] = uID;
        }
    } else {
        incomes[cnt] = height;
        uIDs[cnt] = uID;
        cnt++;
    }
}

int getTop10(int result[10]) {
    for (int i = 0; i < cnt; i++) 
        result[i] = uIDs[i];
        
    return cnt;
}