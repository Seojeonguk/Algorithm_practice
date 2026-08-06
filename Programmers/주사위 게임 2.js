class Solution {
    public int solution(int a, int b, int c) {
        int answer = a + b + c;
        if (a == b && b == c) {
            answer = (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2)) * (pow(a, 3) + pow(b, 3) + pow(c, 3));
        } else if (a == b || b == c || a == c) {
            answer = (a + b + c) * (pow(a, 2) + pow(b, 2) + pow(c, 2));
        }
        return answer;
    }
    
    public int pow(int a, int b) {
        int ret = 1;
        for (int i = 0; i < b; i++) {
            ret *= a;
        }

        return ret;
    }
}