class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = arr;

        for (int i = 0; i < query.length; i++) {
            int[] temp = answer;
            if (i % 2 == 0) {
                temp = new int[query[i] + 1];
                System.arraycopy(answer, 0, temp, 0, temp.length);
            } else {
                temp = new int[answer.length - query[i]];
                System.arraycopy(answer, query[i], temp, 0, temp.length);
            }

            answer = temp;
        }

        return answer;
    }
}