import java.util.*;
class Solution {
    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> sectionWidth = calSectionWidth(k);
        for(int idx=0;idx< ranges.length;idx++) {
            int prev = ranges[idx][0];
            int after = ranges[idx][1];
            after += sectionWidth.size();

            if(prev > after-1) {
                answer[idx] = -1.0;
            } else {
                answer[idx] = sectionWidth.get(after-1) - sectionWidth.get(prev);
            }
        }
        for(double s : answer)
            System.out.println(s);
        return answer;
    }

    public static ArrayList<Double> calSectionWidth(int k) {
        ArrayList<Double> ret = new ArrayList<>();

        ret.add(0.0);
        int left = k , right=k;
        while(right!=1) {
            left = right;
            if(right%2==0) {
                right /= 2;
            } else {
                right = right*3+1;
            }
            Double prevWidth = (ret.size()==0?0.0:ret.get(ret.size()-1));
            ret.add(prevWidth+(left+right)/2.0);
        }

        return ret;
    }
}