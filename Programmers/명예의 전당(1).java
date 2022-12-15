import java.util.*;
class Solution {
    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int idx=0;idx<score.length;idx++) {
            pq.add(score[idx]);
            if(pq.size()>k)
                pq.poll();

            answer[idx] = pq.peek();
        }
        System.out.println(pq.peek());
        return answer;
    }
}