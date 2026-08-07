class Solution {
    public int solution(int[] arr) {
        int ans = 0;

        for (int rec = 0; ; rec++) {
            int[] temp = new int[arr.length];

            System.arraycopy(arr, 0, temp, 0, arr.length);

            for (int idx = 0; idx < arr.length; idx++) {
                if (temp[idx] >= 50 && temp[idx] % 2 == 0) {
                    temp[idx] /= 2;
                } else if (temp[idx] < 50 && temp[idx] % 2 == 1) {
                    temp[idx] = temp[idx] * 2 + 1;
                }
            }

            boolean isEqual = true;
            for (int idx = 0; idx < arr.length; idx++) {
                if (arr[idx] != temp[idx]) {
                    isEqual = false;
                    break;
                }
            }

            if (isEqual) {
                ans = rec;
                break;
            }

            arr = temp;
        }

        return ans;
    }
}